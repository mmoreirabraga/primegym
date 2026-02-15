package br.com.playgramador.primegym.infraestrutura.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.playgramador.primegym.infraestrutura.persistencia.Cliente;

@Repository
public interface ClienteRepository extends  CrudRepository<Cliente, Long>{

    boolean existsByCpf(String cpf);
    boolean existsById(Long id);
}
