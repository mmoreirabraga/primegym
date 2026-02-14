package br.com.playgramador.primegym.aplicacao.mapeador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.playgramador.primegym.aplicacao.entrada.NovoFornecedor;
import br.com.playgramador.primegym.negocio.dominio.FornecedorDominio;
import jakarta.validation.Valid;

@Mapper(componentModel = "spring")
public interface AppFornecedorMapeador {

    @Mapping(target = "id", ignore = true)
    FornecedorDominio paraDominio(@Valid NovoFornecedor novoFornecedor);
}
