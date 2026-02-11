package br.com.playgramador.primegym.application.usecase;

import br.com.playgramador.primegym.repo.FornecedorRepository;
import br.com.playgramador.primegym.shared.annotation.UseCase;
import br.com.playgramador.primegym.shared.excecao.BusinessException;
import br.com.playgramador.primegym.web.dto.NovoFornecedor;
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
