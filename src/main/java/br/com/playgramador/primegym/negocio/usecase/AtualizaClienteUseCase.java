package br.com.playgramador.primegym.negocio.usecase;

import org.springframework.transaction.annotation.Transactional;

import br.com.playgramador.primegym.negocio.annotation.UseCase;
import br.com.playgramador.primegym.negocio.dominio.ClienteDominio;
import br.com.playgramador.primegym.negocio.port.ClientePorta;
import br.com.playgramador.primegym.negocio.service.PoliticaValidacaoCliente;

@UseCase
public class AtualizaClienteUseCase {

    private final ClientePorta clientePorta;
    private final PoliticaValidacaoCliente politicaValidacaoCliente;


    public AtualizaClienteUseCase(ClientePorta clientePorta, PoliticaValidacaoCliente politicaValidacaoCliente) {
        this.clientePorta = clientePorta;
        this.politicaValidacaoCliente = politicaValidacaoCliente;
    }

    @Transactional
    public void execute(Long id, ClienteDominio cliente) {

        politicaValidacaoCliente.validarSeIdExiste(id);

        cliente.setId(id);

        clientePorta.atualizar(cliente);
    }

}
