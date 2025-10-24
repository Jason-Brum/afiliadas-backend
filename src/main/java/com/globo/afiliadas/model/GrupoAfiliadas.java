package com.globo.afiliadas.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TAFIAFIGRP0", schema = "AFIP")
public class GrupoAfiliadas {

    @Id
    @Column(name = "OI_GRUPO")
    private Long id;

    @Column(name = "NM_GRUPO")
    private String nomeGrupo;

    @Column(name = "DH_EXCLUSAO")
    private LocalDate dataExclusao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public LocalDate getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(LocalDate dataExclusao) {
        this.dataExclusao = dataExclusao;
    }
}
