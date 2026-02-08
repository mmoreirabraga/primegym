package br.com.playgramador.primegym.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.playgramador.primegym.domain.model.Usuario;
import java.util.Optional;


public interface UsuarioRepository extends CrudRepository<Usuario, UUID>{

    public boolean existsByUsername(String username);
    public boolean existsByEmail(String email);
    public Optional<Usuario> findByUsername(String username);
    public Optional<Usuario> findByEmail(String email);
}
