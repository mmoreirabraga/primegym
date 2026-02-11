package br.com.playgramador.primegym.infraestrutura.mapeador;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.playgramador.primegym.infraestrutura.persistencia.Usuario;
import br.com.playgramador.primegym.negocio.dominio.UsuarioDominio;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapeador {

    Usuario paraEntidade(UsuarioDominio usuario);

    UsuarioDominio paraDominio(Usuario usuario);
}
