package br.com.playgramador.primegym.web.dto;

import org.hibernate.validator.constraints.br.CNPJ;

import br.com.playgramador.primegym.domain.model.Fornecedor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NovoFornecedor(
    @NotBlank(message = "{campo.obrigatorio}")
    @CNPJ(message = "{cnpj_invalido}")
    @Size(min = 14, max = 14, message = "{cnpj_tamanho}")
    String cnpj,
    
    @NotBlank(message = "{campo.obrigatorio}")
    String razaoSocial,
    @NotBlank(message = "{campo.obrigatorio}") 
    String nomeFantasia
) {

    public Fornecedor converterParaEntidade(){
        return new Fornecedor(cnpj, razaoSocial, nomeFantasia);
    }
}
