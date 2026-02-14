package br.com.playgramador.primegym.aplicacao.mapeador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.playgramador.primegym.aplicacao.entrada.NovoUsuario;
import br.com.playgramador.primegym.negocio.dominio.UsuarioDominio;
import jakarta.validation.Valid;

@Mapper(componentModel = "spring")
public interface AppUsuarioMapeador {
    
    @Mapping(target = "id", ignore = true)
    UsuarioDominio paraDominio(@Valid NovoUsuario novoUsuario);
}
