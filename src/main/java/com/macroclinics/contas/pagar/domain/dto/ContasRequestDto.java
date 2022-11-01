package com.macroclinics.contas.pagar.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
public class ContasRequestDto {

    @ApiModelProperty(name = "Descrição", example = "Conta de água")
    private String descricao;

    @ApiModelProperty(name = "Data da Competência")
    private LocalDate dataCompetencia;

    @ApiModelProperty(name = "Data do Vencimento")
    private LocalDate dataVencimento;

    @ApiModelProperty(name = "Valor",  example = "19,90")
    private String valor;

    @ApiModelProperty(name = "Data do Pagamento")
    private LocalDate dataPagamento;

    @ApiModelProperty(name = "Desconto", example = "10,50")
    private String desconto;

    @ApiModelProperty(name = "Juros", example = "4,50")
    private String juros;

    @ApiModelProperty(name = "Multa", example = "10,00")
    private String multa;

    @ApiModelProperty(name = "Valor Pago", example = "19,90")
    private String valorPago;

    @ApiModelProperty(name = "Fornecedor", example = "1")
    private Integer fornecedorId;
}
