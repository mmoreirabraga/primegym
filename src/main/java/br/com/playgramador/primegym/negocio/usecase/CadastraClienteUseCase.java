package br.com.playgramador.primegym.negocio.usecase;

import org.springframework.transaction.annotation.Transactional;

import br.com.playgramador.primegym.negocio.annotation.UseCase;
import br.com.playgramador.primegym.negocio.dominio.ClienteDominio;
import br.com.playgramador.primegym.negocio.port.ClientePorta;
import br.com.playgramador.primegym.negocio.service.PoliticaValidacaoCliente;

@UseCase
public class CadastraClienteUseCase {

    private final ClientePorta clientePorta;
    private final PoliticaValidacaoCliente politicaValidacaoCliente;


    public CadastraClienteUseCase(ClientePorta clientePorta, PoliticaValidacaoCliente politicaValidacaoCliente) {
        this.clientePorta = clientePorta;
        this.politicaValidacaoCliente = politicaValidacaoCliente;
    }


    @Transactional
    public void execute(ClienteDominio clienteDominio) {

        politicaValidacaoCliente.cpfJaCadastrado(clienteDominio.getCpf());
        clientePorta.salvar(clienteDominio);

    }



}
