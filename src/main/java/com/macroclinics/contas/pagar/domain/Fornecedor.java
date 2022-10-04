package com.macroclinics.contas.pagar.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    private String nome;
    private String cnpj_cpf;
    private Boolean situacao;

    @OneToMany
    private List<Contas> contas;
}
