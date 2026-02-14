package br.com.playgramador.primegym.infraestrutura.mapeador;

import org.mapstruct.Mapper;

import br.com.playgramador.primegym.infraestrutura.persistencia.Fornecedor;
import br.com.playgramador.primegym.negocio.dominio.FornecedorDominio;

@Mapper(componentModel = "spring")
public interface FornecedorMapeador {

    Fornecedor paraEntidade(FornecedorDominio fornecedorDominio);

    FornecedorDominio paraDominio(Fornecedor fornecedor);

}
