package com.example.roads.controllers;

import com.example.roads.dto.IcpfTabela;
import com.example.roads.dto.IcpfTabelaLinha;
import com.example.roads.services.ICPFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IcpfController {

    @Autowired
    private ICPFService icpfService;

    @GetMapping("getTabelaIcpf")
    public IcpfTabela getTabelaIcpf() {
        return icpfService.gerarTabela();
    }

    @GetMapping("getTabelaIcpf/rodovia/{rodoviaId}")
    public IcpfTabela getTabelaIcpfPorRodovia(@PathVariable Long rodoviaId) {
        return icpfService.gerarTabelaPorRodovia(rodoviaId);
    }

    @GetMapping("calcularIcpf/{seguimentoId}")
    public IcpfTabelaLinha calcularIcpf(@PathVariable Long seguimentoId) {
        return icpfService.calcularIcpf(seguimentoId);
    }

    @PostMapping("salvarIcpf/{seguimentoId}")
    public IcpfTabelaLinha calcularESalvarIcpf(@PathVariable Long seguimentoId) {
        return icpfService.calcularESalvarIcpf(seguimentoId);
    }
}
