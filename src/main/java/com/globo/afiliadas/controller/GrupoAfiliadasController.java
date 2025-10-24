package com.globo.afiliadas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globo.afiliadas.model.GrupoAfiliadas;
import com.globo.afiliadas.repository.GrupoAfiliadasRepository;

@RestController
@RequestMapping("/api/grupoAfiliadas")
@CrossOrigin(origins = "http://localhost:3000")
public class GrupoAfiliadasController {

    private final GrupoAfiliadasRepository repository;

    public GrupoAfiliadasController(GrupoAfiliadasRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ativos")
    public List<GrupoAfiliadas> listarAtivos() {
        return repository.findByDataExclusaoIsNull();
    }

    // ✅ Novo endpoint - listar todos, inclusive os inativos, em ordem alfabética
    @GetMapping("/todos")
    public List<GrupoAfiliadas> listarTodosOrdenados() {
        return repository.findAllOrderByNomeGrupoAsc();
    }
}
