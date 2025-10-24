package com.globo.afiliadas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TAFILNCTPO0", schema = "AFIP")
public class TipoLancamento {

    @Id
    @Column(name = "OI_TIPO_LNC")
    private Integer id;

    @Column(name = "NM_TIPO", length = 100)
    private String nomeTipo;

    @Column(name = "CT_TIPO")
    private Integer tipo; // 1 = impacto na fatura, 0 = sem impacto
}
