package com.globo.afiliadas.dto; // ou .dto

import java.time.LocalDate;

// Este é o "Contrato" que o seu React vai receber.
// Note os nomes dos campos batendo com o React.
public class ProjetoDTO {

    private String deProjeto;
    private LocalDate diVigencia; // Usamos LocalDate para consistência
    private LocalDate dfVigencia; // Usamos LocalDate
    private String indCalculaPrest;

    // Construtor é essencial para a mágica do Passo 2
    public ProjetoDTO(String deProjeto, LocalDate diVigencia, LocalDate dfVigencia, String indCalculaPrest) {
        this.deProjeto = deProjeto;
        this.diVigencia = diVigencia;
        this.dfVigencia = dfVigencia;
        this.indCalculaPrest = indCalculaPrest;
    }

    // Getters e Setters
    public String getDeProjeto() { return deProjeto; }
    public void setDeProjeto(String deProjeto) { this.deProjeto = deProjeto; }

    public LocalDate getDiVigencia() { return diVigencia; }
    public void setDiVigencia(LocalDate diVigencia) { this.diVigencia = diVigencia; }

    public LocalDate getDfVigencia() { return dfVigencia; }
    public void setDfVigencia(LocalDate dfVigencia) { this.dfVigencia = dfVigencia; }

    public String getIndCalculaPrest() { return indCalculaPrest; }
    public void setIndCalculaPrest(String indCalculaPrest) { this.indCalculaPrest = indCalculaPrest; }
}