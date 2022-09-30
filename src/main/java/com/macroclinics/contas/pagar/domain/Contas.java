package com.macroclinics.contas.pagar.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class Contas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descricao;

    private Date dataCompetencia;

    private Date dataVencimento;

    private String valor;

    private Date dataPagamento;

    private String desconto;

    private String juros;

    private String multa;

    private String valorPago;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    public void setFornecedor(Integer fornecedorId) {
        this.id = fornecedorId;
    }


}


