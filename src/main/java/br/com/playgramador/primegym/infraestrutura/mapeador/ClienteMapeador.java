package br.com.playgramador.primegym.infraestrutura.mapeador;

import org.mapstruct.Mapper;

import br.com.playgramador.primegym.infraestrutura.persistencia.Cliente;
import br.com.playgramador.primegym.negocio.dominio.ClienteDominio;

@Mapper(componentModel = "spring")
public interface ClienteMapeador {

    Cliente paraEntidade(ClienteDominio clienteDominio);
    ClienteDominio paraDominio(Cliente clienteEntidade);
}
