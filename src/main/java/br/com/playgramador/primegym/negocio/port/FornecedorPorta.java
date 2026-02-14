package br.com.playgramador.primegym.negocio.port;

import br.com.playgramador.primegym.negocio.dominio.FornecedorDominio;

public interface FornecedorPorta {

    boolean existeCnpjCadastrado(String cnpj);
    FornecedorDominio salvar(FornecedorDominio fornecedorDominio);
}
