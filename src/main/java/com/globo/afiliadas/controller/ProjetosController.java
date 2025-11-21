package com.globo.afiliadas.controller;

import com.globo.afiliadas.model.Projeto;
import com.globo.afiliadas.model.ProjetoVigencia;
import com.globo.afiliadas.service.ProjetoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/projetos")
public class ProjetosController {

    private final ProjetoService service;

    public ProjetosController(ProjetoService service) {
        this.service = service;
    }

    // 1. Lista tudo (Traz o Projeto Pai + Lista de Vigências Filhas)
    @GetMapping
    public List<Projeto> listarTudo() {
        return service.listarTudo();
    }

    // 2. Busca Projeto por ID
    @GetMapping("/{id}")
    public Projeto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // 3. Busca Vigência Específica (Pela Chave Composta)
    // Ex: /api/projetos/1/vigencias/2025-01-01
    @GetMapping("/{id}/vigencias/{data}")
    public ProjetoVigencia buscarVigenciaUnica(
            @PathVariable Long id, 
            @PathVariable LocalDate data
    ) {
        return service.buscarVigenciaEspecifica(id, data);
    }
}