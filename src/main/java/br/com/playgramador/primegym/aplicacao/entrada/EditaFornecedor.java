package br.com.playgramador.primegym.aplicacao.entrada;

import jakarta.validation.constraints.NotBlank;

public record EditaFornecedor(

    @NotBlank(message = "{campo.obrigatorio}")
    String razaoSocial,
    @NotBlank(message = "{campo.obrigatorio}") 
    String nomeFantasia
) {

}
