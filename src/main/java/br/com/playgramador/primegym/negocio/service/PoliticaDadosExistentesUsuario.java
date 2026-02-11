package br.com.playgramador.primegym.negocio.service;

import br.com.playgramador.primegym.negocio.annotation.DomainService;
import br.com.playgramador.primegym.negocio.excecao.BusinessException;
import br.com.playgramador.primegym.negocio.port.UsuarioPorta;

@DomainService
public class PoliticaDadosExistentesUsuario {

    private final UsuarioPorta usuarioPorta;

    public PoliticaDadosExistentesUsuario(UsuarioPorta usuarioPorta) {
        this.usuarioPorta = usuarioPorta;
    }

    public void usernameJaCadastrado(String username) {

        if (usuarioPorta.existeUsernameCadastrado(username)) {
            throw new BusinessException("username.existe", username);
        }
    }
    

    public void emailJaCadastrado(String email) {
        
        if (usuarioPorta.existeEmailCadastrado(email)){
            throw new BusinessException("email.existe", email);
        }
        
    }
}
