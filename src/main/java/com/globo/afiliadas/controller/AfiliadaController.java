package com.globo.afiliadas.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globo.afiliadas.model.Afiliada;
import com.globo.afiliadas.repository.AfiliadaRepository;

@RestController
@RequestMapping("/api/afiliadas")
@CrossOrigin(origins = "http://localhost:3000")
public class AfiliadaController {

    private final AfiliadaRepository repository;

    public AfiliadaController(AfiliadaRepository repository) {
        this.repository = repository;
    }

    // ===============================
    // LISTAGEM GERAL
    // ===============================
    @GetMapping
    public List<Afiliada> listar() {
        return repository.findAll();
    }

    // ===============================
    // BUSCA POR ID
    // ===============================
    @GetMapping("/{id}")
    public ResponseEntity<Afiliada> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ===============================
    // LISTAGEM ATIVAS / INATIVAS
    // ===============================
    @GetMapping("/ativas")
    public List<Afiliada> listarAtivas() {
        return repository.findByAtivo("S");
    }

    @GetMapping("/inativas")
    public List<Afiliada> listarInativas() {
        return repository.findByAtivo("N");
    }

    // ===============================
    // SALVAR NOVA AFILIADA
    // ===============================
    @PostMapping
    public Afiliada salvar(@RequestBody Afiliada afiliada) {
        if (afiliada.getExibidora() == null || afiliada.getExibidora().isEmpty()) {
            afiliada.setExibidora("GLOBO"); // valor padrão
        }
        return repository.save(afiliada);
    }

    // ===============================
    // EXCLUIR
    // ===============================
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // ===============================
    // ATUALIZAR
    // ===============================
    @PutMapping("/{id}")
    public ResponseEntity<Afiliada> atualizar(@PathVariable Long id, @RequestBody Afiliada afiliadaAtualizada) {
        return repository.findById(id)
                .map(afiliadaExistente -> {
                    afiliadaAtualizada.setId(id);
                    return ResponseEntity.ok(repository.save(afiliadaAtualizada));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ===============================
    // LISTAR POR UF
    // ===============================
    @GetMapping("/por-uf/{uf}")
    public List<Afiliada> listarPorUf(@PathVariable String uf) {
        return repository.findByUf(uf.toUpperCase());
    }

    // ===============================
    // ATIVAR / INATIVAR
    // ===============================
    @PatchMapping("/{id}/ativar")
    public ResponseEntity<Afiliada> ativar(@PathVariable Long id) {
        return repository.findById(id)
                .map(afiliada -> {
                    afiliada.setAtivo("S");
                    afiliada.setDataInativacao(null);
                    return ResponseEntity.ok(repository.save(afiliada));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Afiliada> inativar(@PathVariable Long id) {
        return repository.findById(id)
                .map(afiliada -> {
                    afiliada.setAtivo("N");
                    afiliada.setDataInativacao(LocalDate.now());
                    return ResponseEntity.ok(repository.save(afiliada));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ===============================
    // NOVA ROTA DE BUSCA FILTRADA
    // ===============================
    @GetMapping("/buscar")
    public List<Afiliada> buscar(
            @RequestParam(required = false) String nomeFantasia,
            @RequestParam(required = false) String codigoContabil,
            @RequestParam(required = false) String exibidora,   // mnemônico
            @RequestParam(required = false) Boolean inativa     // true/false; null = ignora
    ) {
        String ativo = null;
        if (inativa != null) {
            ativo = inativa ? "N" : "S";
        }
        return repository.buscar(nomeFantasia, codigoContabil, exibidora, ativo);
    }
}
