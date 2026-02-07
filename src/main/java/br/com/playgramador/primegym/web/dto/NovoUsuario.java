package br.com.playgramador.primegym.web.dto;

import br.com.playgramador.primegym.domain.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record NovoUsuario(
    @NotBlank(message = "{campo.obrigatorio}") 
    String username,
    @Email(message = "{email.invalido}")
    @NotBlank(message = "{campo.obrigatorio}")
    String email,
    @NotBlank(message = "{campo.obrigatorio}")
    String senha,
    @NotBlank(message = "{campo.obrigatorio}")
    String confirmaSenha
) {

    public Usuario converterParaEntidade(){
        return new Usuario(username().toLowerCase(), email().toLowerCase(), senha());
    }
}
