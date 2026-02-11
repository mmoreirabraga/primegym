package br.com.playgramador.primegym.aplicacao.entrada;

public record LoginRequest(
        String usernameOrEmail,
        String senha
) {

}
