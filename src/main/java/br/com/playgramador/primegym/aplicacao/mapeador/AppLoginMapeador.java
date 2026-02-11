package br.com.playgramador.primegym.aplicacao.mapeador;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.playgramador.primegym.aplicacao.entrada.LoginRequest;
import br.com.playgramador.primegym.negocio.dominio.LoginRequestDominio;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppLoginMapeador {

    LoginRequestDominio paraDominio(LoginRequest loginRequest);
}
