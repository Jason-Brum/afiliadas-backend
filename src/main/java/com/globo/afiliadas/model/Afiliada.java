package com.globo.afiliadas.model;


import java.time.LocalDate; 
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "TAFIAFI0", schema = "AFIP")
public class Afiliada {

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAFIAFI0_SEQ" )
    @SequenceGenerator(name = "TAFIAFI0_SEQ", sequenceName = "AFIP.TAFIAFI0_SEQ",  allocationSize = 1)
	@Column(name = "OI_AFILIADA", nullable = false, unique = true)
	private Long id;

    @Column(name = "OI_GRUPO")
    private Long oiGrupo;

    @Column(name = "CD_CONTABIL", length = 6)
    private String codigoContabil;

    @Column(name = "NU_CNPJ", length = 14)
    private String cnpj;

    @Column(name = "DE_RAZAO_SOCIAL", length = 100)
    private String razaoSocial;

    @Column(name = "DE_NOME_FANTASIA", length = 50)
    private String nomeFantasia;

    @Column(name = "ME_EXIBIDORA", length = 15)
    private String exibidora;

    @Column(name = "DE_INSC_ESTADUAL", length = 20)
    private String inscricaoEstadual;

    @Column(name = "DE_INSC_MUNICIPAL", length = 20)
    private String inscricaoMunicipal;

    @Column(name = "NM_LOGRADOURO", length = 60)
    private String logradouro;

    @Column(name = "NU_NUMERO", length = 15)
    private String numero;

    @Column(name = "NM_COMPLEMENTO", length = 30)
    private String complemento;

    @Column(name = "NM_BAIRRO", length = 50)
    private String bairro;

    @Column(name = "NM_MUNICIPIO", length = 60)
    private String municipio;

    @Column(name = "NU_CEP", length = 8)
    private String cep;

    @Column(name = "DE_UF", length = 2)
    private String uf;

    @Column(name = "DE_EMAIL_PRIMARIO", length = 60)
    private String emailPrimario;

    @Column(name = "DE_EMAIL_SECUNDARIO", length = 60)
    private String emailSecundario;

    @Column(name = "CD_BANCO", length = 5)
    private String banco;

    @Column(name = "NU_AGENCIA", length = 6)
    private String agencia;

    @Column(name = "NU_CONTA", length = 20)
    private String conta;

    @Column(name = "CT_TRAVA_DOMICILIO", length = 1)
    private String travaDomicilio;

    @Column(name = "CT_ATIVO", length = 1)
    private String ativo;

    @Column(name = "DT_INATIVACAO")
    private LocalDate dataInativacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DH_ALTERACAO")
    private Date dhAlteracao;

    @Column(name = "NM_USUARIO_ALTERACAO", length = 30)
    private String usuarioAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DH_INCLUSAO")
    private Date dhInclusao;
}
