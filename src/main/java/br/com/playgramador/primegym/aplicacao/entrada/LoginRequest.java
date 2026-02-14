package br.com.playgramador.primegym.aplicacao.entrada;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "{campo.obrigatorio}")
        String usernameOrEmail,
        @NotBlank(message= "{campo.obrigatorio}")
        String senha
) {

}
