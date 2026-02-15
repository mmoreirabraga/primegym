package br.com.playgramador.primegym.aplicacao.mapeador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.playgramador.primegym.aplicacao.entrada.EditaCliente;
import br.com.playgramador.primegym.aplicacao.entrada.NovoCliente;
import br.com.playgramador.primegym.negocio.dominio.ClienteDominio;
import jakarta.validation.Valid;

@Mapper(componentModel = "spring")
public interface AppClienteMapeador {

    @Mapping(target = "id", ignore = true)
    ClienteDominio paraDomino(@Valid NovoCliente novoCliente);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    ClienteDominio paraDominio(@Valid EditaCliente editaCliente);
}
