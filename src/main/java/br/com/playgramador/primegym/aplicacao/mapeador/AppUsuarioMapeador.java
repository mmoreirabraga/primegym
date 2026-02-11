package br.com.playgramador.primegym.aplicacao.mapeador;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.playgramador.primegym.aplicacao.entrada.NovoUsuario;
import br.com.playgramador.primegym.negocio.dominio.UsuarioDominio;
import jakarta.validation.Valid;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppUsuarioMapeador {

    UsuarioDominio paraDominio(@Valid NovoUsuario novoUsuario);
}
