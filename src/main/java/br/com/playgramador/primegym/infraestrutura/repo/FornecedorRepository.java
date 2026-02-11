package br.com.playgramador.primegym.infraestrutura.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.playgramador.primegym.infraestrutura.persistencia.Fornecedor;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Long>{

    boolean existsByCnpj(String cnpj);

}
