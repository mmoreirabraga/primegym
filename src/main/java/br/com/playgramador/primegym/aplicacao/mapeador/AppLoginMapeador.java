package br.com.playgramador.primegym.aplicacao.mapeador;

import org.mapstruct.Mapper;

import br.com.playgramador.primegym.aplicacao.entrada.LoginRequest;
import br.com.playgramador.primegym.negocio.dominio.LoginRequestDominio;

@Mapper(componentModel = "spring")
public interface AppLoginMapeador {

    LoginRequestDominio paraDominio(LoginRequest loginRequest);
}
