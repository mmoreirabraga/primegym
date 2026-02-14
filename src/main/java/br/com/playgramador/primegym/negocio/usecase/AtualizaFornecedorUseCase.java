package br.com.playgramador.primegym.negocio.usecase;

import org.springframework.transaction.annotation.Transactional;

import br.com.playgramador.primegym.negocio.annotation.UseCase;
import br.com.playgramador.primegym.negocio.dominio.FornecedorDominio;
import br.com.playgramador.primegym.negocio.excecao.ResourceNotFoundException;
import br.com.playgramador.primegym.negocio.port.FornecedorPorta;
import br.com.playgramador.primegym.negocio.service.PoliticaValidacaoFornecedor;

@UseCase
public class AtualizaFornecedorUseCase {

    private final FornecedorPorta fornecedorPorta;
    private final PoliticaValidacaoFornecedor politicaValidacaoFornecedor;
    
    public AtualizaFornecedorUseCase(FornecedorPorta fornecedorPorta,
                                        PoliticaValidacaoFornecedor politicaValidacaoFornecedor) {
          this.fornecedorPorta = fornecedorPorta;
          this.politicaValidacaoFornecedor = politicaValidacaoFornecedor;
     }

     @Transactional
     public void execute(Long id, FornecedorDominio fornecedor) {
        

        politicaValidacaoFornecedor.validarSeIdExiste(id);
        fornecedor.setId(id);

        fornecedorPorta.atualizar(fornecedor);
     }
}
