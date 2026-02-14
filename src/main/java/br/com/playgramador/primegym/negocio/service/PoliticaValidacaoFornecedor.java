package br.com.playgramador.primegym.negocio.service;

import br.com.playgramador.primegym.negocio.annotation.DomainService;
import br.com.playgramador.primegym.negocio.excecao.BusinessException;
import br.com.playgramador.primegym.negocio.excecao.ResourceNotFoundException;
import br.com.playgramador.primegym.negocio.port.FornecedorPorta;

@DomainService
public class PoliticaValidacaoFornecedor {

    private final FornecedorPorta fornecedorPorta;

    public PoliticaValidacaoFornecedor(FornecedorPorta fornecedorPorta) {
        this.fornecedorPorta = fornecedorPorta;
    }

    
    public void cnpjJaCadastrado(String cnpj) {

        if (fornecedorPorta.existeCnpjCadastrado(cnpj)){
             throw new BusinessException("cnpj_existe", cnpj);
        }
   }

   public void validarSeIdExiste(Long id) {
        if (!fornecedorPorta.isIdExiste(id)){
            throw new ResourceNotFoundException("recurso_nao_encontrado");
        }
   }
}
