package br.com.playgramador.primegym.negocio.port;

import java.util.Optional;

import br.com.playgramador.primegym.negocio.dominio.FornecedorDominio;

public interface FornecedorPorta {

    boolean existeCnpjCadastrado(String cnpj);
    FornecedorDominio salvar(FornecedorDominio fornecedor);
    FornecedorDominio atualizar(FornecedorDominio fornecedor);
    Optional<FornecedorDominio> buscarFornecedorPeloId(Long id);
    boolean isIdExiste(Long id);
    void deletar(Long id);
}
