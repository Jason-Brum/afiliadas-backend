package com.globo.afiliadas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.globo.afiliadas.model.Banco;

public interface BancoRepository extends JpaRepository<Banco, String> {

    // Todos os bancos: primeiro códigos puramente numéricos (ordenados numericamente),
    // depois os demais (ordenados alfabeticamente pelo código).
    @Query(value = """
        SELECT CD_CODIGO, NM_BANCO
          FROM AFIP.TAFIBCO0
         ORDER BY
           CASE
             WHEN REGEXP_LIKE(CD_CODIGO, '^[0-9]+$') THEN TO_NUMBER(CD_CODIGO)
             ELSE NULL
           END ASC,
           CD_CODIGO ASC
        """, nativeQuery = true)
    List<Banco> findAllOrderByCodigoInteligente();
}
