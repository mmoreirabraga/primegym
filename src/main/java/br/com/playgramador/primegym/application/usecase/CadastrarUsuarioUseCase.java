package br.com.playgramador.primegym.application.usecase;

import org.springframework.transaction.annotation.Transactional;

import br.com.playgramador.primegym.domain.port.UsuarioRepository;
import br.com.playgramador.primegym.domain.service.PoliticaSenha;
import br.com.playgramador.primegym.shared.annotation.UseCase;
import br.com.playgramador.primegym.shared.excecao.BusinessException;
import br.com.playgramador.primegym.web.dto.NovoUsuario;

@UseCase
public class CadastrarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final PoliticaSenha politicaSenha;

    public CadastrarUsuarioUseCase(UsuarioRepository usuarioRepository, PoliticaSenha politicaSenha) {
        this.usuarioRepository = usuarioRepository;
        this.politicaSenha = politicaSenha;
    }

    /**
     * Salva o usuário
     */
    @Transactional
    public void execute(NovoUsuario novoUsuario) {

        this.politicaSenha.validarConfirmacao(novoUsuario.senha(), novoUsuario.confirmaSenha());
        
        usernameJaCadastrado(novoUsuario.username());

        emailJaCadastrado(novoUsuario.email());

        var usuario = novoUsuario.converterParaEntidade();

        usuarioRepository.save(usuario);
    }

    private void usernameJaCadastrado(String username) {
        if (usuarioRepository.existsByUsername(username)){
            throw new BusinessException("username.existe", username);
        }
    }

    private void emailJaCadastrado(String email) {
        if (usuarioRepository.existsByEmail(email)){
            throw new BusinessException("email.existe", email);
        }
    }

}
