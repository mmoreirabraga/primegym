package br.com.playgramador.primegym.aplicacao.mapeador;

import org.mapstruct.Mapper;

import br.com.playgramador.primegym.aplicacao.entrada.LoginRequest;
import br.com.playgramador.primegym.negocio.dominio.LoginRequestDominio;
import jakarta.validation.Valid;

@Mapper(componentModel = "spring")
public interface AppLoginMapeador {

    LoginRequestDominio paraDominio(@Valid LoginRequest loginRequest);
}
