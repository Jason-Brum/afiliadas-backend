package com.globo.afiliadas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.globo.afiliadas.model.Afiliada;

public interface AfiliadaRepository extends JpaRepository<Afiliada, Long> {

    List<Afiliada> findByAtivo(String ativo);
    List<Afiliada> findByUf(String uf);


    @Query("""
        SELECT a
        FROM Afiliada a
        WHERE (:nomeFantasia IS NULL OR LOWER(a.nomeFantasia) LIKE LOWER(CONCAT('%', :nomeFantasia, '%')))
          AND (:codigoContabil IS NULL OR a.codigoContabil = :codigoContabil)
          AND (:exibidora IS NULL OR LOWER(a.exibidora) LIKE LOWER(CONCAT('%', :exibidora, '%')))
          AND (:ativo IS NULL OR a.ativo = :ativo)
        ORDER BY a.codigoContabil ASC
    """)
    List<Afiliada> buscar(
        @Param("nomeFantasia") String nomeFantasia,
        @Param("codigoContabil") String codigoContabil,
        @Param("exibidora") String exibidora,   // “mnemônico” na tela
        @Param("ativo") String ativo            // 'S' ou 'N' (null = ignora)
    );
}
