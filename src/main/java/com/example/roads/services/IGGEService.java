package com.example.roads.services;

import com.example.roads.dto.IggeResultado;
import com.example.roads.entities.Afundamento;
import com.example.roads.entities.CadastroSeguimento;
import com.example.roads.entities.Deformacoes;
import com.example.roads.entities.Igge;
import com.example.roads.entities.Ondulacoes;
import com.example.roads.entities.Panelas;
import com.example.roads.entities.Remendos;
import com.example.roads.entities.Trincas;
import com.example.roads.repositories.CadastroSeguimentoRepository;
import com.example.roads.repositories.IggeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IGGEService {

    private static final double FREQUENCIA_ALTA = 50.0;
    private static final double FREQUENCIA_MEDIA = 10.0;
    private static final double QUANTIDADE_ALTA = 5.0;
    private static final double QUANTIDADE_MEDIA = 2.0;

    private static final double PESO_PT_ALTA = 0.65;
    private static final double PESO_PT_MEDIA = 0.45;
    private static final double PESO_PT_BAIXA = 0.30;

    private static final double PESO_POAP_ALTA = 1.00;
    private static final double PESO_POAP_MEDIA = 0.70;
    private static final double PESO_POAP_BAIXA = 0.60;

    private static final double PESO_PPR_ALTA = 1.00;
    private static final double PESO_PPR_MEDIA = 0.80;
    private static final double PESO_PPR_BAIXA = 0.70;

    @Autowired
    private CadastroSeguimentoRepository cadastroSeguimentoRepository;

    @Autowired
    private IggeRepository iggeRepository;

    public IGGEService() {
    }

    @Transactional(readOnly = true)
    public IggeResultado calcularIgge(Long seguimentoId) {
        return calcularResultado(buscarSeguimento(seguimentoId));
    }

    @Transactional
    public IggeResultado calcularESalvarIgge(Long seguimentoId) {
        CadastroSeguimento seguimento = buscarSeguimento(seguimentoId);
        IggeResultado resultado = calcularResultado(seguimento);

        Igge igge = iggeRepository.findFirstBySeguimento_Id(seguimentoId).orElseGet(Igge::new);
        igge.setSeguimento(seguimento);
        igge.setValorIgge(resultado.getValorIgge());
        iggeRepository.save(igge);

        return resultado;
    }

    @Transactional(readOnly = true)
    public IggeResultado calcularResultado(Long seguimentoId) {
        return calcularResultado(buscarSeguimento(seguimentoId));
    }

    public IggeResultado calcularResultado(CadastroSeguimento seguimento) {
        double ft = somarPorcentagemTrincas(seguimento);
        double foap = somarPorcentagemDeformacoes(seguimento);
        double fpr = calcularFrequenciaPanelasRemendos(seguimento);

        double pt = pesoPt(ft);
        double poap = pesoPoap(foap);
        double ppr = pesoPpr(fpr);

        double ftPt = arredondar(ft * pt);
        double foapPoap = arredondar(foap * poap);
        double fprPpr = arredondar(fpr * ppr);
        double valorIgge = arredondar(ftPt + foapPoap + fprPpr);

        /*Cria um DTO com os resultados */return new IggeResultado(
                seguimento.getId(),
                seguimento.getNumSeguimento(),
                seguimento.getSeguimentoInicial(),
                seguimento.getSeguimentoFinal(),
                calcularExtensao(seguimento),
                ft,
                pt,
                ftPt,
                foap,
                poap,
                foapPoap,
                fpr,
                ppr,
                fprPpr,
                valorIgge
        );
    }

    public double calcularValorIgge(CadastroSeguimento seguimento) {
        return calcularResultado(seguimento).getValorIgge();
    }

    private CadastroSeguimento buscarSeguimento(Long seguimentoId) {
        return cadastroSeguimentoRepository.findById(seguimentoId)
                .orElseThrow(() -> new EntityNotFoundException("Seguimento não encontrado: " + seguimentoId));
    }

    private double somarPorcentagemTrincas(CadastroSeguimento seguimento) {
        List<Trincas> trincas = seguimento.getTrincas();
        if (trincas == null) {
            return 0.0;
        }
        return trincas.stream().mapToDouble(Trincas::getPorcentagemKm).sum();
    }

    private double somarPorcentagemDeformacoes(CadastroSeguimento seguimento) {
        double total = 0.0;

        List<Afundamento> afundamentos = seguimento.getAfundamentos();
        if (afundamentos != null) {
            total += afundamentos.stream().mapToDouble(Afundamento::getPorcetagemAfundamento).sum();
        }

        List<Ondulacoes> ondulacoes = seguimento.getOndulacoes();
        if (ondulacoes != null) {
            total += ondulacoes.stream().mapToDouble(Ondulacoes::getPorcetagemOnduacoesKm).sum();
        }

        if (total > 0.0) {
            return total;
        }

        List<Deformacoes> deformacoes = seguimento.getDeformacoes();
        if (deformacoes == null) {
            return 0.0;
        }
        return deformacoes.stream().mapToDouble(Deformacoes::getPorcentagemKm).sum();
    }

    private double calcularFrequenciaPanelasRemendos(CadastroSeguimento seguimento) {
        double total = 0.0;

        List<Panelas> panelas = seguimento.getPanelas();
        if (panelas != null) {
            total += panelas.stream().mapToInt(Panelas::getQuantidade).sum();
        }

        List<Remendos> remendos = seguimento.getRemendos();
        if (remendos != null) {
            total += remendos.stream().mapToInt(Remendos::getQuantidade).sum();
        }

        double extensao = calcularExtensao(seguimento);
        return extensao > 0.0 ? total / extensao : total;
    }

    private double calcularExtensao(CadastroSeguimento seguimento) {
        double extensao = seguimento.getExtensaoSeguimento();
        if (extensao <= 0.0) {
            extensao = seguimento.getSeguimentoFinal() - seguimento.getSeguimentoInicial();
        }
        return extensao;
    }

    private double pesoPt(double frequencia) {
        if (frequencia >= FREQUENCIA_ALTA) {
            return PESO_PT_ALTA;
        }
        if (frequencia > FREQUENCIA_MEDIA) {
            return PESO_PT_MEDIA;
        }
        return PESO_PT_BAIXA;
    }

    private double pesoPoap(double frequencia) {
        if (frequencia >= FREQUENCIA_ALTA) {
            return PESO_POAP_ALTA;
        }
        if (frequencia > FREQUENCIA_MEDIA) {
            return PESO_POAP_MEDIA;
        }
        return PESO_POAP_BAIXA;
    }

    private double pesoPpr(double quantidadePorKm) {
        if (quantidadePorKm >= QUANTIDADE_ALTA) {
            return PESO_PPR_ALTA;
        }
        if (quantidadePorKm > QUANTIDADE_MEDIA) {
            return PESO_PPR_MEDIA;
        }
        return PESO_PPR_BAIXA;
    }

    private double arredondar(double valor) {
        return Math.round(valor * 10.0) / 10.0;
    }
}
