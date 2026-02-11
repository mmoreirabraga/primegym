package br.com.playgramador.primegym.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.playgramador.primegym.domain.model.Fornecedor;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Long>{

    boolean existsByCnpj(String cnpj);

}
