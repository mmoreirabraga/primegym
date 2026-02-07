package br.com.playgramador.primegym.domain.service;

import br.com.playgramador.primegym.shared.annotation.DomainService;
import br.com.playgramador.primegym.shared.excecao.BusinessException;

@DomainService
public class PoliticaSenha {

    public void validarConfirmacao(String senha, String confirmarSenha) {
        if (!isSenhasIguais(senha, confirmarSenha)) {
            throw new BusinessException("senhas.diferentes");
        }
    }

    private boolean isSenhasIguais(String senha1, String senha2) {
        return (senha1 != null && senha2 != null) && senha1.equals(senha2);
    }

}
