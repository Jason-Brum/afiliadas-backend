package com.globo.afiliadas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
@Table(name = "TAFI_PROJETO_VIGENCIA")
public class ProjetoVigencia {

    @EmbeddedId
    private ProjetoVigenciaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("oiProjeto")
    @JoinColumn(name = "OI_PROJETO")
    @JsonBackReference
    private Projeto projeto;

    @Column(name = "DF_VIGENCIA")
    private LocalDate dataFimVigencia;

    @Column(name = "IND_CALCULA_PREST")
    private String indCalculaPrest;

    @Column(name = "DH_INCLUSAO")
    private LocalDateTime dataInclusao;

    @Column(name = "NM_USUARIO_ALTERACAO")
    private String usuarioAlteracao;
}