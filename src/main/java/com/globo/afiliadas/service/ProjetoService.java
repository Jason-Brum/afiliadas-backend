package com.globo.afiliadas.service;

import com.globo.afiliadas.model.Projeto;
import com.globo.afiliadas.model.ProjetoVigencia;
import com.globo.afiliadas.model.ProjetoVigenciaId; // Importante
import com.globo.afiliadas.repository.ProjetoRepository;
import com.globo.afiliadas.repository.ProjetoVigenciaRepository; // Importante
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final ProjetoVigenciaRepository vigenciaRepository; // Injeção nova

    // Atualize o construtor para receber os dois repositórios
    public ProjetoService(ProjetoRepository projetoRepository, ProjetoVigenciaRepository vigenciaRepository) {
        this.projetoRepository = projetoRepository;
        this.vigenciaRepository = vigenciaRepository;
    }

    public List<Projeto> listarTudo() {
        return projetoRepository.findAll();
    }

    public Projeto buscarPorId(Long id) {
        return projetoRepository.findById(id).orElse(null);
    }

    // --- O MÉTODO QUE VOCÊ QUER ---
    public ProjetoVigencia buscarVigenciaEspecifica(Long idProjeto, LocalDate dataInicio) {
        try {    // 2. Monta a Chave Composta na mão
            ProjetoVigenciaId idComposto = new ProjetoVigenciaId(idProjeto, dataInicio);

            // 3. Busca no banco usando a chave composta
            return vigenciaRepository.findById(idComposto).orElse(null);
        } catch (Exception e) {
            return null; // Retorna nulo se a data for inválida ou não achar
        }
    }
}