package br.com.playgramador.primegym.infraestrutura.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.playgramador.primegym.infraestrutura.persistencia.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, UUID>{

    public boolean existsByUsername(String username);
    public boolean existsByEmail(String email);
    public Usuario findByUsername(String username);
    public Usuario findByEmail(String email);
}
