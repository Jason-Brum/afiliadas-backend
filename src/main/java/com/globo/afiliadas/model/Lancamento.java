package com.globo.afiliadas.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "TAFILNC0", schema = "AFIP")
public class Lancamento {

    @Id
    @Column(name = "OI_LANCAMENTO")
    private Long id;

    @Column(name = "CD_COMPETENCIA")
    private Integer competencia;

    // 🔹 Relação com afiliada
    @ManyToOne
    @JoinColumn(name = "OI_AFILIADA")
    private Afiliada afiliada;

    // 🔹 Relação com tipo de lançamento (TAFILNCTPO0)
    @ManyToOne
    @JoinColumn(name = "OI_TIPO_LNC")
    private TipoLancamento tipoLancamento;

    @Column(name = "DE_DESCRICAO", length = 200)
    private String descricao;

    @Column(name = "VL_LANCAMENTO")
    private Double valor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DH_INCLUSAO")
    private Date dataInclusao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DH_ALTERACAO")
    private Date dataAlteracao;

    @Column(name = "NM_USUARIO_ULT_ALTERACAO", length = 30)
    private String usuarioUltAlteracao;

    @Column(name = "CT_STATUS_FATURAMENTO", length = 1)
    private String statusFaturamento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DH_EXCLUSAO")
    private Date dataExclusao;

    @Column(name = "CT_TIPO", length = 1)
    private String tipo; // entrada/saída (E/S)

    // 🔹 Relação com categoria (TAFILNCCAT0)
    @ManyToOne
    @JoinColumn(name = "CD_CATEGORIA")
    private CategoriaLancamento categoria;
}
