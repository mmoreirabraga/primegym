package br.com.playgramador.primegym.negocio.dominio;

public record LoginRequestDominio(
    String usernameOrEmail,
    String senha
) {

}
