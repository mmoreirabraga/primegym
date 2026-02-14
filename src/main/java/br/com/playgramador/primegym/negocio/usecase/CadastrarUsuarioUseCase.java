package br.com.playgramador.primegym.negocio.usecase;

import org.springframework.transaction.annotation.Transactional;

import br.com.playgramador.primegym.negocio.annotation.UseCase;
import br.com.playgramador.primegym.negocio.dominio.UsuarioDominio;
import br.com.playgramador.primegym.negocio.port.UsuarioPorta;
import br.com.playgramador.primegym.negocio.service.PoliticaDadosExistentesUsuario;
import br.com.playgramador.primegym.negocio.service.PoliticaSenha;

@UseCase
public class CadastrarUsuarioUseCase {

    private final PoliticaDadosExistentesUsuario politicaDadosExistentesUsuario;
    private final PoliticaSenha politicaSenha;  
    private final UsuarioPorta usuarioPorta;

    public CadastrarUsuarioUseCase(PoliticaDadosExistentesUsuario politicaDadosExistentesUsuario,
            PoliticaSenha politicaSenha, UsuarioPorta usuarioPorta) {
        this.politicaDadosExistentesUsuario = politicaDadosExistentesUsuario;
        this.politicaSenha = politicaSenha;
        this.usuarioPorta = usuarioPorta;
    }
    /**
     * Salva o usuário
     */
    @Transactional
    public void execute(UsuarioDominio usuarioDominio) {

        this.politicaSenha.validarConfirmacao(usuarioDominio.getSenha(), usuarioDominio.getConfirmaSenha());
        
        politicaDadosExistentesUsuario.usernameJaCadastrado(usuarioDominio.getUsername());

        politicaDadosExistentesUsuario.emailJaCadastrado(usuarioDominio.getEmail());

        usuarioDominio.setSenha(politicaSenha.gerarHash(usuarioDominio.getSenha()));
        usuarioPorta.salvar(usuarioDominio);
    }

}
