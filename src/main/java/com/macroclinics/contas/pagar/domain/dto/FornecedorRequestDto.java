package com.macroclinics.contas.pagar.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FornecedorRequestDto {
    @NotNull(message = "O nome do fornecedor deve ser informado.")
    private String nome;
    //@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    @NotBlank(message =  "O cnpj ou cpf não deve ser em branco.")
    private String cnpj_cpf;
    private Boolean situacao;
}
