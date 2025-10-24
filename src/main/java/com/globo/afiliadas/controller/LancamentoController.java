package com.globo.afiliadas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globo.afiliadas.model.Lancamento;
import com.globo.afiliadas.repository.LancamentoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/lancamentos")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Lançamentos", description = "Endpoints relacionados aos lançamentos financeiros das afiliadas")
public class LancamentoController {

    private final LancamentoRepository repository;

    public LancamentoController(LancamentoRepository repository) {
        this.repository = repository;
    }

    @Operation(summary = "Listar todos os lançamentos", description = "Retorna a lista completa de lançamentos cadastrados.")
    @GetMapping
    public List<Lancamento> listarTodos() {
        return repository.findAll();
    }

    @Operation(summary = "Buscar lançamento por ID", description = "Retorna os detalhes de um lançamento específico pelo seu ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> buscarPorId(
            @Parameter(description = "ID do lançamento a ser consultado") 
            @PathVariable Long id) {
        Optional<Lancamento> lancamento = repository.findById(id);
        return lancamento.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Criar novo lançamento", description = "Cadastra um novo lançamento no sistema.")
    @PostMapping
    public Lancamento criar(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Objeto JSON representando o lançamento a ser criado") 
            @RequestBody Lancamento lancamento) {
        return repository.save(lancamento);
    }

    @Operation(summary = "Atualizar lançamento existente", description = "Atualiza um lançamento com base no ID informado.")
    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> atualizar(
            @Parameter(description = "ID do lançamento a ser atualizado") 
            @PathVariable Long id,
            @RequestBody Lancamento lancamentoAtualizado) {
        return repository.findById(id)
                .map(lancamento -> {
                    lancamentoAtualizado.setId(id);
                    return ResponseEntity.ok(repository.save(lancamentoAtualizado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Excluir lançamento", description = "Remove permanentemente um lançamento do banco de dados.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do lançamento a ser deletado") 
            @PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // === Filtros ===

    @Operation(summary = "Listar lançamentos por afiliada", description = "Retorna os lançamentos vinculados à afiliada informada.")
    @GetMapping("/por-afiliada/{id}")
    public List<Lancamento> listarPorAfiliada(
            @Parameter(description = "ID da afiliada") 
            @PathVariable Long id) {
        return repository.findByAfiliadaId(id);
    }

    @Operation(summary = "Listar lançamentos por categoria", description = "Retorna os lançamentos associados a uma categoria específica.")
    @GetMapping("/por-categoria/{codigo}")
    public List<Lancamento> listarPorCategoria(
            @Parameter(description = "Código da categoria") 
            @PathVariable Integer codigo) {
        return repository.findByCategoria_Id(codigo);
    }

    @Operation(summary = "Listar lançamentos por tipo (E/S)", description = "Filtra lançamentos pela coluna CT_TIPO (Entrada ou Saída).")
    @GetMapping("/por-tipo/{tipo}")
    public List<Lancamento> listarPorTipo(
            @Parameter(description = "Tipo: 'E' para entrada ou 'S' para saída") 
            @PathVariable String tipo) {
        return repository.findByTipo(tipo);
    }

    @Operation(summary = "Listar lançamentos por tipo de lançamento", description = "Filtra lançamentos pelo ID do tipo de lançamento (FK OI_TIPO_LNC).")
    @GetMapping("/por-tipo-lancamento/{idTipoLancamento}")
    public List<Lancamento> listarPorTipoLancamento(
            @Parameter(description = "ID do tipo de lançamento") 
            @PathVariable Integer idTipoLancamento) {
        return repository.findByTipoLancamento_Id(idTipoLancamento);
    }

    @Operation(summary = "Listar lançamentos por status de faturamento", description = "Filtra lançamentos de acordo com o status de faturamento (CT_STATUS_FATURAMENTO).")
    @GetMapping("/por-status/{status}")
    public List<Lancamento> listarPorStatus(
            @Parameter(description = "Status de faturamento (por exemplo: 'P', 'A', 'C')") 
            @PathVariable String status) {
        return repository.findByStatusFaturamento(status);
    }
}
