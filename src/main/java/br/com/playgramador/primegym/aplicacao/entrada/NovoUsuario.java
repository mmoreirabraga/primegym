package br.com.playgramador.primegym.aplicacao.entrada;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NovoUsuario(
    @NotBlank(message = "{campo.obrigatorio}")
    @Size(min = 2, max = 100, message = "{tamanho_dado_campo}")
    String username,
    @Email(message = "{email.invalido}")
    @NotBlank(message = "{campo.obrigatorio}")
    @Size(min = 2, max = 255, message = "{tamanho_dado_campo}")
    String email,
    @NotBlank(message = "{campo.obrigatorio}")
    @Size(min = 2, max = 255, message = "{tamanho_dado_campo}")
    String senha,
    @NotBlank(message = "{campo.obrigatorio}")
    @Size(min = 2, max = 255, message = "{tamanho_dado_campo}")
    String confirmaSenha
) {

}
