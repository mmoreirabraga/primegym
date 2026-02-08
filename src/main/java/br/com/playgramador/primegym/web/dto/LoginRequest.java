package br.com.playgramador.primegym.web.dto;

public record LoginRequest(
        String usernameOrEmail,
        String senha
) {

}
