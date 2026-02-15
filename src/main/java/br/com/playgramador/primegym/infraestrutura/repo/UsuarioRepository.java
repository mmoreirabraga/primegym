package br.com.playgramador.primegym.infraestrutura.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.playgramador.primegym.infraestrutura.persistencia.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, UUID>{

    public boolean existsByUsername(String username);
    public boolean existsByEmail(String email);
    public Usuario findByUsername(String username);
    public Usuario findByEmail(String email);
}
