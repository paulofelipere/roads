package com.example.roads.services;

import com.example.roads.dto.IcpfTabela;
import com.example.roads.dto.IcpfTabelaLinha;
import com.example.roads.entities.Afundamento;
import com.example.roads.entities.CadastroSeguimento;
import com.example.roads.entities.Deformacoes;
import com.example.roads.entities.Desgaste;
import com.example.roads.entities.Escorregamento;
import com.example.roads.entities.Exsudacao;
import com.example.roads.entities.Icpf;
import com.example.roads.entities.Ondulacoes;
import com.example.roads.entities.Panelas;
import com.example.roads.entities.Remendos;
import com.example.roads.entities.Rodovia;
import com.example.roads.entities.Trincas;
import com.example.roads.repositories.CadastroSeguimentoRepository;
import com.example.roads.repositories.IcpfRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ICPFService {

    private static final String SEM_DEFEITO = "-";

    private static final double ICPF_ALTA = 1.0;
    private static final double ICPF_MEDIA = 2.5;
    private static final double ICPF_BAIXA = 3.0;
    private static final double ICPF_SEM_DEFEITO = 5.0;

    @Autowired
    private CadastroSeguimentoRepository cadastroSeguimentoRepository;

    @Autowired
    private IcpfRepository icpfRepository;

    @Transactional(readOnly = true)
    public IcpfTabela gerarTabela() {
        List<CadastroSeguimento> seguimentos = cadastroSeguimentoRepository.findAll();
        seguimentos.sort(Comparator.comparingInt(CadastroSeguimento::getNumSeguimento));
        return new IcpfTabela(null, null, montarLinhas(seguimentos));
    }

    @Transactional(readOnly = true)
    public IcpfTabela gerarTabelaPorRodovia(Long rodoviaId) {
        List<CadastroSeguimento> seguimentos =
                cadastroSeguimentoRepository.findByRodovia_IdOrderByNumSeguimentoAsc(rodoviaId);

        if (seguimentos.isEmpty()) {
            return new IcpfTabela(rodoviaId, null, new ArrayList<>());
        }

        Rodovia rodovia = seguimentos.get(0).getRodovia();
        Long idRodovia = rodovia != null ? rodovia.getId() : rodoviaId;
        Integer numRodovia = rodovia != null ? rodovia.getNumRodovia() : null;
        return new IcpfTabela(idRodovia, numRodovia, montarLinhas(seguimentos));
    }

    @Transactional(readOnly = true)
    public double calcularIcpfMedio() {
        return calcularMediaIcpf(cadastroSeguimentoRepository.findAll());
    }

    @Transactional(readOnly = true)
    public double calcularIcpfMedioPorRodovia(Long rodoviaId) {
        return calcularMediaIcpf(
                cadastroSeguimentoRepository.findByRodovia_IdOrderByNumSeguimentoAsc(rodoviaId));
    }

    public double calcularMediaIcpf(List<CadastroSeguimento> seguimentos) {
        if (seguimentos == null || seguimentos.isEmpty()) {
            return 0.0;
        }

        double soma = 0.0;
        int quantidade = 0;
        for (CadastroSeguimento seguimento : seguimentos) {
            if (seguimento != null) {
                soma += calcularValorIcpf(seguimento);
                quantidade++;
            }
        }

        if (quantidade == 0) {
            return 0.0;
        }

        return Math.round((soma / quantidade) * 100.0) / 100.0;
    }

    public double calcularValorIcpf(CadastroSeguimento seguimento) {
        return montarLinha(seguimento).getIcpf();
    }

    private List<IcpfTabelaLinha> montarLinhas(List<CadastroSeguimento> seguimentos) {
        List<IcpfTabelaLinha> linhas = new ArrayList<>();
        for (CadastroSeguimento seguimento : seguimentos) {
            linhas.add(montarLinha(seguimento));
        }
        return linhas;
    }

    private IcpfTabelaLinha montarLinha(CadastroSeguimento seguimento) {
        IcpfTabelaLinha linha = new IcpfTabelaLinha();
        linha.setNumeroSeguimento(seguimento.getNumSeguimento());
        linha.setKmInicio(seguimento.getSeguimentoInicial());
        linha.setKmFim(seguimento.getSeguimentoFinal());
        linha.setExtensaoKm(calcularExtensao(seguimento));
        linha.setP(codigoPanelas(seguimento));
        linha.setTrincas(new IcpfTabelaLinha.TrincasDTO(
                codigoTrincaIsolada(seguimento),
                codigoTrincaCouroDeJacare(seguimento),
                codigoTrincaEmBloco(seguimento)
        ));
        linha.setR(codigoRemendos(seguimento));
        linha.setDeformacoes(new IcpfTabelaLinha.DeformacoesDTO(
                codigoAfundamento(seguimento),
                codigoOndulacao(seguimento),
                codigoDesgaste(seguimento)
        ));
        linha.setOutrosDefeitos(new IcpfTabelaLinha.OutrosDefeitosDTO(
                codigoExsudacao(seguimento),
                codigoEscorregamento(seguimento)
        ));
        linha.setIcpf(calcularIcpf(linha));
        return linha;
    }

    public double calcularIcpf(IcpfTabelaLinha linha) {
        IcpfTabelaLinha.TrincasDTO trincas = linha.getTrincas();
        IcpfTabelaLinha.DeformacoesDTO deformacoes = linha.getDeformacoes();
        IcpfTabelaLinha.OutrosDefeitosDTO outrosDefeitos = linha.getOutrosDefeitos();

        String[] codigos = {
                linha.getP(),
                trincas != null ? trincas.getTr() : null,
                trincas != null ? trincas.getTj() : null,
                trincas != null ? trincas.getTb() : null,
                linha.getR(),
                deformacoes != null ? deformacoes.getAf() : null,
                deformacoes != null ? deformacoes.getO() : null,
                deformacoes != null ? deformacoes.getD() : null,
                outrosDefeitos != null ? outrosDefeitos.getEx() : null,
                outrosDefeitos != null ? outrosDefeitos.getE() : null
        };

        double soma = 0.0;
        int quantidade = 0;
        for (String codigo : codigos) {
            double valor = valorDoCodigo(codigo);
            if (valor >= 0.0) {
                soma += valor;
                quantidade++;
            }
        }

        if (quantidade == 0) {
            return ICPF_SEM_DEFEITO;
        }

        return arredondarIcpf(soma / quantidade);
    }

    public String calcularConceito(double valorIcpf) {
        if (valorIcpf >= 4.0) {
            return "Ótimo";
        }
        if (valorIcpf >= 3.0) {
            return "Bom";
        }
        if (valorIcpf >= 2.0) {
            return "Regular";
        }
        if (valorIcpf >= 1.0) {
            return "Ruim";
        }
        return "Péssimo";
    }

    private double valorDoCodigo(String codigo) {
        if (codigo == null || SEM_DEFEITO.equals(codigo.trim())) {
            return -1.0;
        }
        if ("A".equals(codigo)) {
            return ICPF_ALTA;
        }
        if ("M".equals(codigo)) {
            return ICPF_MEDIA;
        }
        if ("B".equals(codigo)) {
            return ICPF_BAIXA;
        }
        return -1.0;
    }

    private double arredondarIcpf(double valor) {
        double limitado = Math.max(0.0, Math.min(5.0, valor));
        return Math.round(limitado * 2.0) / 2.0;
    }

    @Transactional(readOnly = true)
    public IcpfTabelaLinha calcularIcpf(Long seguimentoId) {
        return montarLinha(buscarSeguimento(seguimentoId));
    }

    @Transactional
    public IcpfTabelaLinha calcularESalvarIcpf(Long seguimentoId) {
        CadastroSeguimento seguimento = buscarSeguimento(seguimentoId);
        IcpfTabelaLinha linha = montarLinha(seguimento);

        Icpf icpf = icpfRepository.findFirstBySeguimento_Id(seguimentoId).orElseGet(Icpf::new);
        icpf.setSeguimento(seguimento);
        icpf.setValorIcpf(linha.getIcpf());
        icpf.setConceito(calcularConceito(linha.getIcpf()));
        icpfRepository.save(icpf);

        return linha;
    }

    private CadastroSeguimento buscarSeguimento(Long seguimentoId) {
        return cadastroSeguimentoRepository.findById(seguimentoId)
                .orElseThrow(() -> new EntityNotFoundException("Seguimento não encontrado: " + seguimentoId));
    }

    private String codigoPanelas(CadastroSeguimento seguimento) {
        String resultado = SEM_DEFEITO;
        for (Panelas panelas : listaOuVazia(seguimento.getPanelas())) {
            resultado = piorCodigo(resultado, codigoPorGravidade(panelas.getGravidade(), panelas.getCodigo()));
        }
        return resultado;
    }

    private String codigoRemendos(CadastroSeguimento seguimento) {
        String resultado = SEM_DEFEITO;
        for (Remendos remendos : listaOuVazia(seguimento.getRemendos())) {
            resultado = piorCodigo(resultado, codigoPorGravidade(remendos.getGravidade(), remendos.getCodigoRemendos()));
        }
        return resultado;
    }

    private String codigoTrincaIsolada(CadastroSeguimento seguimento) {
        String resultado = SEM_DEFEITO;
        for (Trincas trincas : listaOuVazia(seguimento.getTrincas())) {
            if (isTrincaIsolada(trincas.getTipoTrinca())) {
                resultado = piorCodigo(resultado,
                        codigoPorGravidade(trincas.getGravidadeTrincas(), trincas.getCodigoTrinca()));
            }
        }
        return resultado;
    }

    private String codigoTrincaCouroDeJacare(CadastroSeguimento seguimento) {
        String resultado = SEM_DEFEITO;
        for (Trincas trincas : listaOuVazia(seguimento.getTrincas())) {
            if (isTrincaCouroDeJacare(trincas.getTipoTrinca())) {
                resultado = piorCodigo(resultado,
                        codigoPorGravidade(trincas.getGravidadeTrincas(), trincas.getCodigoTrinca()));
            }
        }
        return resultado;
    }

    private String codigoTrincaEmBloco(CadastroSeguimento seguimento) {
        String resultado = SEM_DEFEITO;
        for (Trincas trincas : listaOuVazia(seguimento.getTrincas())) {
            if (isTrincaEmBloco(trincas.getTipoTrinca())) {
                resultado = piorCodigo(resultado,
                        codigoPorGravidade(trincas.getGravidadeTrincas(), trincas.getCodigoTrinca()));
            }
        }
        return resultado;
    }

    private String codigoAfundamento(CadastroSeguimento seguimento) {
        String resultado = SEM_DEFEITO;
        for (Afundamento afundamento : listaOuVazia(seguimento.getAfundamentos())) {
            resultado = piorCodigo(resultado,
                    codigoPorGravidade(afundamento.getGravidadeAfundamento(), afundamento.getCodigoAfundamento()));
        }
        for (Deformacoes deformacoes : listaOuVazia(seguimento.getDeformacoes())) {
            if (isAfundamento(deformacoes.getTipoDefeito())) {
                resultado = piorCodigo(resultado,
                        codigoPorGravidade(deformacoes.getGravidade(), deformacoes.getCodigo()));
            }
        }
        return resultado;
    }

    private String codigoOndulacao(CadastroSeguimento seguimento) {
        String resultado = SEM_DEFEITO;
        for (Ondulacoes ondulacoes : listaOuVazia(seguimento.getOndulacoes())) {
            resultado = piorCodigo(resultado,
                    codigoPorGravidade(ondulacoes.getGravidadeOndulacoes(), ondulacoes.getCodigoOndulacao()));
        }
        for (Deformacoes deformacoes : listaOuVazia(seguimento.getDeformacoes())) {
            if (isOndulacao(deformacoes.getTipoDefeito())) {
                resultado = piorCodigo(resultado,
                        codigoPorGravidade(deformacoes.getGravidade(), deformacoes.getCodigo()));
            }
        }
        return resultado;
    }

    private String codigoDesgaste(CadastroSeguimento seguimento) {
        String resultado = SEM_DEFEITO;
        for (Desgaste desgaste : listaOuVazia(seguimento.getDesgastes())) {
            resultado = piorCodigo(resultado,
                    codigoPorGravidade(desgaste.getGravidadeDesgaste(), desgaste.getCodigoDesgaste()));
        }
        for (Deformacoes deformacoes : listaOuVazia(seguimento.getDeformacoes())) {
            if (isDesgaste(deformacoes.getTipoDefeito())) {
                resultado = piorCodigo(resultado,
                        codigoPorGravidade(deformacoes.getGravidade(), deformacoes.getCodigo()));
            }
        }
        return resultado;
    }

    private String codigoExsudacao(CadastroSeguimento seguimento) {
        String resultado = SEM_DEFEITO;
        for (Exsudacao exsudacao : listaOuVazia(seguimento.getExsudacoes())) {
            resultado = piorCodigo(resultado,
                    codigoPorGravidade(exsudacao.getGravidadeExsudacao(), exsudacao.getCodigoExsudacao()));
        }
        return resultado;
    }

    private String codigoEscorregamento(CadastroSeguimento seguimento) {
        String resultado = SEM_DEFEITO;
        for (Escorregamento escorregamento : listaOuVazia(seguimento.getEscorregamentos())) {
            resultado = piorCodigo(resultado,
                    codigoPorGravidade(escorregamento.getGravidadeEscorregamento(),
                            escorregamento.getCodigoEscorregamento()));
        }
        return resultado;
    }

    private String codigoPorGravidade(int gravidade, String codigo) {
        if (gravidade >= 3) {
            return "A";
        }
        if (gravidade == 2) {
            return "M";
        }
        if (gravidade == 1) {
            return "B";
        }
        return normalizarCodigo(codigo);
    }

    private String normalizarCodigo(String codigo) {
        if (codigo == null) {
            return SEM_DEFEITO;
        }
        String normalizado = codigo.trim().toUpperCase();
        if ("A".equals(normalizado) || "M".equals(normalizado)) {
            return normalizado;
        }
        if ("B".equals(normalizado) || "C".equals(normalizado)) {
            return "B";
        }
        return SEM_DEFEITO;
    }

    private String piorCodigo(String atual, String candidato) {
        return pesoCodigo(candidato) > pesoCodigo(atual) ? candidato : atual;
    }

    private int pesoCodigo(String codigo) {
        if ("A".equals(codigo)) {
            return 3;
        }
        if ("M".equals(codigo)) {
            return 2;
        }
        if ("B".equals(codigo)) {
            return 1;
        }
        return 0;
    }

    private boolean isTrincaIsolada(String tipo) {
        String normalizado = normalizarTexto(tipo);
        return "TR".equals(normalizado) || normalizado.contains("ISOLADA");
    }

    private boolean isTrincaCouroDeJacare(String tipo) {
        String normalizado = normalizarTexto(tipo);
        return "TJ".equals(normalizado) || normalizado.contains("JACARE") || normalizado.contains("COURO");
    }

    private boolean isTrincaEmBloco(String tipo) {
        String normalizado = normalizarTexto(tipo);
        return "TB".equals(normalizado) || normalizado.contains("BLOCO");
    }

    private boolean isAfundamento(String tipo) {
        String normalizado = normalizarTexto(tipo);
        return "AF".equals(normalizado) || normalizado.contains("AFUNDA");
    }

    private boolean isOndulacao(String tipo) {
        String normalizado = normalizarTexto(tipo);
        return "O".equals(normalizado) || normalizado.contains("ONDULA");
    }

    private boolean isDesgaste(String tipo) {
        String normalizado = normalizarTexto(tipo);
        return "D".equals(normalizado) || normalizado.contains("DESGASTE");
    }

    private String normalizarTexto(String valor) {
        if (valor == null) {
            return "";
        }
        String semAcento = Normalizer.normalize(valor, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        return semAcento.trim().toUpperCase();
    }

    private double calcularExtensao(CadastroSeguimento seguimento) {
        double extensao = seguimento.getExtensaoSeguimento();
        if (extensao <= 0.0) {
            extensao = seguimento.getSeguimentoFinal() - seguimento.getSeguimentoInicial();
        }
        return extensao;
    }

    private <T> List<T> listaOuVazia(List<T> lista) {
        return lista != null ? lista : List.of();
    }
}
