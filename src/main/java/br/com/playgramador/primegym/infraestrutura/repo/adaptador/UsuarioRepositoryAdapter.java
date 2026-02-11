package br.com.playgramador.primegym.infraestrutura.repo.adaptador;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.playgramador.primegym.infraestrutura.mapeador.UsuarioMapeador;
import br.com.playgramador.primegym.infraestrutura.repo.UsuarioRepository;
import br.com.playgramador.primegym.negocio.dominio.UsuarioDominio;
import br.com.playgramador.primegym.negocio.port.UsuarioPorta;

@Component
public class UsuarioRepositoryAdapter implements UsuarioPorta{

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapeador usuarioMapeador;

    public UsuarioRepositoryAdapter(UsuarioRepository usuarioRepository, UsuarioMapeador usuarioMapeador) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapeador = usuarioMapeador;
    }

    @Override
    public UsuarioDominio salvar(UsuarioDominio usuarioDominio) {
        var usuarioEntidade = usuarioMapeador.paraEntidade(usuarioDominio);

        return usuarioMapeador.paraDominio(this.usuarioRepository.save(usuarioEntidade));
        
    }

    @Override
    public boolean existeUsernameCadastrado(String username) {
        return this.usuarioRepository.existsByUsername(username);
    }

    @Override
    public boolean existeEmailCadastrado(String email) {
        return this.existeEmailCadastrado(email);
    }

    @Override
    public Optional<UsuarioDominio> buscarPeloUsername(String username) {
        return Optional.ofNullable(usuarioMapeador.paraDominio( this.usuarioRepository.findByUsername(username))); 
    }

    @Override
    public Optional<UsuarioDominio> buscarPeloEmail(String email) {
        return Optional.ofNullable(usuarioMapeador.paraDominio(this.usuarioRepository.findByEmail(email)));
    }

}
