package com.macroclinics.contas.pagar.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String cnpj_cpf;
    private Boolean situacao;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj_cpf(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj_cpf() {
        return cnpj_cpf;
    }

    public Boolean getSituacao() {
        return situacao;
    }
}
