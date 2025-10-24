package com.globo.afiliadas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TAFILNCCAT0", schema = "AFIP")
public class CategoriaLancamento {

    @Id
    @Column(name = "CD_CATEGORIA")
    private Integer id;

    @Column(name = "DE_CATEGORIA", length = 150)
    private String nome;

    @Column(name = "CT_ATIVO", length = 1)
    private String ativo;

    @Column(name = "NM_USUARIO_ALTERACAO", length = 50)
    private String usuarioAlteracao;

    @Column(name = "DH_INCLUSAO")
    private java.time.LocalDateTime dataInclusao;

    @Column(name = "DH_ALTERACAO")
    private java.time.LocalDateTime dataAlteracao;
}
