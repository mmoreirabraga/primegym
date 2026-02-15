package br.com.playgramador.primegym.negocio.usecase;

import org.springframework.transaction.annotation.Transactional;

import br.com.playgramador.primegym.negocio.annotation.UseCase;
import br.com.playgramador.primegym.negocio.port.FornecedorPorta;
import br.com.playgramador.primegym.negocio.service.PoliticaValidacaoFornecedor;

@UseCase
public class DeletaFornecedorUseCase {

    private final FornecedorPorta fornecedorPorta;
    private final PoliticaValidacaoFornecedor politicaValidacaoFornecedor;
    
    public DeletaFornecedorUseCase(FornecedorPorta fornecedorPorta,
                                        PoliticaValidacaoFornecedor politicaValidacaoFornecedor) {
          this.fornecedorPorta = fornecedorPorta;
          this.politicaValidacaoFornecedor = politicaValidacaoFornecedor;
     }

     @Transactional
     public void execute(Long id) {

        politicaValidacaoFornecedor.validarSeIdExiste(id);
        
        fornecedorPorta.deletar(id);
     }
}
