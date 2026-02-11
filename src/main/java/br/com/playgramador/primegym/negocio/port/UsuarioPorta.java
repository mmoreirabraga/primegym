package br.com.playgramador.primegym.negocio.port;

import java.util.Optional;

import br.com.playgramador.primegym.negocio.dominio.UsuarioDominio;

public interface UsuarioPorta {

    boolean existeUsernameCadastrado(String username);
    boolean existeEmailCadastrado(String email);
    Optional<UsuarioDominio> buscarPeloUsername(String username);
    Optional<UsuarioDominio> buscarPeloEmail(String email);
    UsuarioDominio salvar(UsuarioDominio usuarioDominio);
}
