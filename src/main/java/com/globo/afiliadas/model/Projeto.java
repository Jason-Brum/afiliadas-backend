package com.globo.afiliadas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
@Table(name = "TAFI_PROJETO")
public class Projeto {

    @Id
    @Column(name = "OI_PROJETO")
    private Long oiProjeto;

    @Column(name = "DE_PROJETO")
    private String descricaoProjeto;

    @Column(name = "CD_NIP")
    private Long cdNip;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ProjetoVigencia> vigencias;

    @Column(name = "DH_INCLUSAO")
    private LocalDateTime dataInclusao;

    @Column(name = "NM_USUARIO_ALTERACAO")
    private String usuarioAlteracao;
}