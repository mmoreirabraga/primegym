package br.com.playgramador.primegym.domain.service;

import org.springframework.security.authentication.BadCredentialsException;

import br.com.playgramador.primegym.domain.port.PasswordHasher;
import br.com.playgramador.primegym.shared.annotation.DomainService;
import br.com.playgramador.primegym.shared.excecao.BusinessException;
import br.com.playgramador.primegym.shared.excecao.UnauthorizedException;

@DomainService
public class PoliticaSenha {

    private final PasswordHasher hasher;

    public PoliticaSenha(PasswordHasher hasher) {
        this.hasher = hasher;
    }

    public void validarConfirmacao(String senha, String confirmarSenha) {
        if (!isSenhasIguais(senha, confirmarSenha)) {
            throw new BusinessException("senhas.diferentes");
        }
    }

    public String gerarHash(String senhaPura) {
        return hasher.hash(senhaPura);
    }

    public void validarSenhaAtravesLogin(String senhaUsuarioInformada, String senhaUsuarioBancoHash){
        if(!hasher.matches(senhaUsuarioInformada, senhaUsuarioBancoHash)) {
            throw new UnauthorizedException("auth.credenciais_invalidas");
        }
    }

    private boolean isSenhasIguais(String senha1, String senha2) {
        return (senha1 != null && senha2 != null) && senha1.equals(senha2);
    }

}
