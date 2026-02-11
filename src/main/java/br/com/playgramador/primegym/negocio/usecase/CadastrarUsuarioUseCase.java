package br.com.playgramador.primegym.negocio.usecase;

import org.springframework.transaction.annotation.Transactional;

import br.com.playgramador.primegym.negocio.annotation.UseCase;
import br.com.playgramador.primegym.negocio.dominio.UsuarioDominio;
import br.com.playgramador.primegym.negocio.port.UsuarioPorta;
import br.com.playgramador.primegym.negocio.service.PoliticaSenha;

@UseCase
public class CadastrarUsuarioUseCase {

    private final UsuarioPorta usuarioPorta;
    private final PoliticaSenha politicaSenha;

    public CadastrarUsuarioUseCase(UsuarioPorta usuarioPorta, PoliticaSenha politicaSenha) {
        this.usuarioPorta = usuarioPorta;
        this.politicaSenha = politicaSenha;
    }

    /**
     * Salva o usuário
     */
    @Transactional
    public void execute(UsuarioDominio usuarioDominio) {

        this.politicaSenha.validarConfirmacao(usuarioDominio.getSenha(), usuarioDominio.getConfirmarSenha());
        
        usuarioPorta.existeUsernameCadastrado(usuarioDominio.getUsername());

        usuarioPorta.existeEmailCadastrado(usuarioDominio.getEmail());

        usuarioDominio.setSenha(politicaSenha.gerarHash(usuarioDominio.getSenha()));
        usuarioPorta.salvar(usuarioDominio);
    }

}
