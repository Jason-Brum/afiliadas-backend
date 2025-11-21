package com.globo.afiliadas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProjetoVigenciaId implements Serializable {

    @Column(name = "OI_PROJETO")
    private Long oiProjeto;

    @Column(name = "DI_VIGENCIA")
    private LocalDate dataInicioVigencia;
}