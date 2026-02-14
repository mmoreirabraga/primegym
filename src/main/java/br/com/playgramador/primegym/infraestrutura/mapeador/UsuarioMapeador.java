package br.com.playgramador.primegym.infraestrutura.mapeador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.playgramador.primegym.infraestrutura.persistencia.Usuario;
import br.com.playgramador.primegym.negocio.dominio.UsuarioDominio;

@Mapper(componentModel = "spring")
public interface UsuarioMapeador {
    
    
    Usuario paraEntidade(UsuarioDominio usuario);

    @Mapping(target = "confirmaSenha", ignore = true)
    UsuarioDominio paraDominio(Usuario usuario);
}
