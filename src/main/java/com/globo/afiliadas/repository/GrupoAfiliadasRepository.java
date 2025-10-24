package com.globo.afiliadas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.globo.afiliadas.model.GrupoAfiliadas;

public interface GrupoAfiliadasRepository extends JpaRepository<GrupoAfiliadas, Long> {

    List<GrupoAfiliadas> findByDataExclusaoIsNull();

    // ✅ Novo método para listar todos em ordem alfabética
    @Query(value = "SELECT g FROM GrupoAfiliadas g ORDER BY g.nomeGrupo ASC")
    List<GrupoAfiliadas> findAllOrderByNomeGrupoAsc();
}
