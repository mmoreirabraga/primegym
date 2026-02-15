package br.com.playgramador.primegym.negocio.usecase;

import org.springframework.transaction.annotation.Transactional;

import br.com.playgramador.primegym.negocio.annotation.UseCase;
import br.com.playgramador.primegym.negocio.port.ClientePorta;
import br.com.playgramador.primegym.negocio.service.PoliticaValidacaoCliente;

@UseCase
public class DeletaClienteUseCase {

    private final ClientePorta clientePorta;
    private final PoliticaValidacaoCliente politicaValidacaoCliente;

    public DeletaClienteUseCase(ClientePorta clientePorta, PoliticaValidacaoCliente politicaValidacaoCliente) {
        this.clientePorta = clientePorta;
        this.politicaValidacaoCliente = politicaValidacaoCliente;
    }

    @Transactional
    public void execute(Long id){

        politicaValidacaoCliente.validarSeIdExiste(id);
        
        clientePorta.deletar(id);
    }
    
}
