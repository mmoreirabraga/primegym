package br.com.playgramador.primegym.aplicacao.mapeador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.playgramador.primegym.aplicacao.entrada.EditaFornecedor;
import br.com.playgramador.primegym.aplicacao.entrada.NovoFornecedor;
import br.com.playgramador.primegym.negocio.dominio.FornecedorDominio;
import jakarta.validation.Valid;

@Mapper(componentModel = "spring")
public interface AppFornecedorMapeador {

    @Mapping(target = "id", ignore = true)
    FornecedorDominio paraDominio(@Valid NovoFornecedor novoFornecedor);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cnpj", ignore = true)
    FornecedorDominio paraDominio(@Valid EditaFornecedor editaFornecedor);
}
