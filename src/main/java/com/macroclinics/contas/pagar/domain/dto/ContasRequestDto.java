package com.macroclinics.contas.pagar.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ContasRequestDto {

    private String descricao;

    private Date dataCompetencia;

    private Date dataVencimento;

    private String valor;

    private Date dataPagamento;

    private String desconto;

    private String juros;

    private String multa;

    private String valorPago;

    private Integer fornecedorId;
}
