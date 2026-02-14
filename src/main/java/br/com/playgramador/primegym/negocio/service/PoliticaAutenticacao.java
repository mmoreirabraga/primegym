package br.com.playgramador.primegym.negocio.service;


import br.com.playgramador.primegym.negocio.annotation.DomainService;
import br.com.playgramador.primegym.negocio.dominio.UsuarioDominio;
import br.com.playgramador.primegym.negocio.excecao.UnauthorizedException;
import br.com.playgramador.primegym.negocio.port.UsuarioPorta;

@DomainService
public class PoliticaAutenticacao {

    private final UsuarioPorta usuarioPorta;
    private final PoliticaSenha politicaSenha; 

    public PoliticaAutenticacao(UsuarioPorta usuarioPorta, PoliticaSenha politicaSenha) {
        this.usuarioPorta = usuarioPorta;
        this.politicaSenha = politicaSenha;
    }

    public UsuarioDominio validaAutenticacao(String usernameOrEmail, String senha) {

        var usuarioDominioOpt = this.usuarioPorta.buscarPeloUsername(usernameOrEmail);

        if (usuarioDominioOpt.isEmpty()) {
            usuarioDominioOpt = this.usuarioPorta.buscarPeloEmail(usernameOrEmail);
        }

        var usuarioDominio = usuarioDominioOpt.orElseThrow(
            () -> new UnauthorizedException("auth.credenciais_invalidas")
        );

        politicaSenha.validarSenhaAtravesLogin(senha, usuarioDominio.getSenha());

        return usuarioDominio;
    }
    
}
