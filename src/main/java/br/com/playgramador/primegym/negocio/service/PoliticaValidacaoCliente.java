package br.com.playgramador.primegym.negocio.service;

import br.com.playgramador.primegym.negocio.annotation.DomainService;
import br.com.playgramador.primegym.negocio.excecao.BusinessException;
import br.com.playgramador.primegym.negocio.excecao.ResourceNotFoundException;
import br.com.playgramador.primegym.negocio.port.ClientePorta;

@DomainService
public class PoliticaValidacaoCliente {

    private final ClientePorta clientePorta;

    public PoliticaValidacaoCliente(ClientePorta clientePorta) {
        this.clientePorta = clientePorta;
    }

    public void cpfJaCadastrado(String cpf) {

        if (clientePorta.existeCpfCadastrado(cpf)){
             throw new BusinessException("cpf_existe", cpf);
        }
   }

   public void validarSeIdExiste(Long id) {
        if (!clientePorta.isIdExiste(id)){
            throw new ResourceNotFoundException("recurso_nao_encontrado");
        }
   }

}
