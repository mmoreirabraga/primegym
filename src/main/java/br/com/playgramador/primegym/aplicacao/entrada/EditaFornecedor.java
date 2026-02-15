package br.com.playgramador.primegym.aplicacao.entrada;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EditaFornecedor(

    @NotBlank(message = "{campo.obrigatorio}")
    @Size(min = 2, max = 255, message = "{tamanho_dado_campo}")
    String razaoSocial,
    @NotBlank(message = "{campo.obrigatorio}") 
    @Size(min = 2, max = 255, message = "{tamanho_dado_campo}")
    String nomeFantasia
) {

}
