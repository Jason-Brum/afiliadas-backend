package com.globo.afiliadas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globo.afiliadas.model.Banco;
import com.globo.afiliadas.repository.BancoRepository;

@RestController
@RequestMapping("/api/banco")
@CrossOrigin(origins = "http://localhost:3000")
public class BancoController {

    private final BancoRepository repository;

    public BancoController(BancoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ativos")
    public List<Banco> listarAtivos() {
        return repository.findAll();
    }

    @GetMapping("/todos")
    public List<Banco> listarTodosOrdenadosPorCodigo() {
        return repository.findAllOrderByCodigoInteligente();
    }
}
