package br.com.playgramador.primegym.negocio.port;

import java.util.Optional;

import br.com.playgramador.primegym.negocio.dominio.ClienteDominio;

public interface ClientePorta {

    boolean existeCpfCadastrado(String cpf);
    ClienteDominio salvar(ClienteDominio cliente);
    ClienteDominio atualizar(ClienteDominio cliente);
    Optional<ClienteDominio> buscarClientePeloId(Long id);
    boolean isIdExiste(Long id);
    void deletar(Long id);
}
