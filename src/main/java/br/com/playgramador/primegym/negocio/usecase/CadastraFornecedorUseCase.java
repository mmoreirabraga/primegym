package br.com.playgramador.primegym.negocio.usecase;

import br.com.playgramador.primegym.negocio.annotation.UseCase;
import br.com.playgramador.primegym.negocio.dominio.FornecedorDominio;
import br.com.playgramador.primegym.negocio.port.FornecedorPorta;
import br.com.playgramador.primegym.negocio.service.PoliticaValidacaoFornecedor;
import jakarta.transaction.Transactional;

@UseCase
public class CadastraFornecedorUseCase {

    private final FornecedorPorta fornecedorPorta;
    private final PoliticaValidacaoFornecedor politicaValidacaoFornecedor;

    public CadastraFornecedorUseCase(FornecedorPorta fornecedorPorta,
                                        PoliticaValidacaoFornecedor politicaValidacaoFornecedor) {
          this.fornecedorPorta = fornecedorPorta;
          this.politicaValidacaoFornecedor = politicaValidacaoFornecedor;
     }

     @Transactional
     public void execute(FornecedorDominio novoFornecedor) {

          politicaValidacaoFornecedor.cnpjJaCadastrado(novoFornecedor.getCnpj());

          fornecedorPorta.salvar(novoFornecedor);
     } 

}
