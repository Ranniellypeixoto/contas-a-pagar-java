package com.macroclinics.contas.pagar.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Contas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    @JsonFormat (shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate dataCompetencia;
    @JsonFormat (shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate dataVencimento;
    private String valor;
    @JsonFormat (shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate dataPagamento;
    private String desconto;
    private String juros;
    private String multa;
    private String valorPago;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

}


