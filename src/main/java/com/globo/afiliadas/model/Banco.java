package com.globo.afiliadas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TAFIBCO0", schema = "AFIP") // confirme se o schema é AFIP
public class Banco {

    @Id
    @Column(name = "CD_CODIGO")
    private String codigo;

    @Column(name = "NM_BANCO")
    private String nome;

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
