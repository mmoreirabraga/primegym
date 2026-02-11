package br.com.playgramador.primegym.negocio.usecase;

import br.com.playgramador.primegym.aplicacao.entrada.NovoFornecedor;
import br.com.playgramador.primegym.infraestrutura.repo.FornecedorRepository;
import br.com.playgramador.primegym.negocio.annotation.UseCase;
import br.com.playgramador.primegym.negocio.excecao.BusinessException;
import jakarta.transaction.Transactional;

@UseCase
public class CadastraFornecedorUseCase {

    private final FornecedorRepository fornecedorRepository;

    public CadastraFornecedorUseCase(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Transactional
   public void execute(NovoFornecedor novoFornecedor) {

        cnpjJaCadastrado(novoFornecedor.cnpj());

        var forncedor = novoFornecedor.converterParaEntidade();

        fornecedorRepository.save(forncedor);
   } 

   private void cnpjJaCadastrado(String cnpj) {

        if (fornecedorRepository.existsByCnpj(cnpj)){
             throw new BusinessException("cnpj_existe", cnpj);
        }
   }
}
