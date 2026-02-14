package br.com.playgramador.primegym.infraestrutura.repo.adaptador;

import org.springframework.stereotype.Component;

import br.com.playgramador.primegym.infraestrutura.mapeador.FornecedorMapeador;
import br.com.playgramador.primegym.infraestrutura.repo.FornecedorRepository;
import br.com.playgramador.primegym.negocio.dominio.FornecedorDominio;
import br.com.playgramador.primegym.negocio.port.FornecedorPorta;

@Component
public class FornecedorRepositoryAdapter implements FornecedorPorta{

    private final FornecedorRepository fornecedorRepository;
    private final FornecedorMapeador fornecedorMapeador;

    public FornecedorRepositoryAdapter(FornecedorRepository fornecedorRepository,
            FornecedorMapeador fornecedorMapeador) {
        this.fornecedorRepository = fornecedorRepository;
        this.fornecedorMapeador = fornecedorMapeador;
    }

    @Override
    public boolean existeCnpjCadastrado(String cnpj) {
       return fornecedorRepository.existsByCnpj(cnpj);
    }

    @Override
    public FornecedorDominio salvar(FornecedorDominio fornecedor) {
        var fornecedorEntidade = fornecedorMapeador.paraEntidade(fornecedor);
        var fornecedorDominio = fornecedorMapeador.paraDominio(this.fornecedorRepository.save(fornecedorEntidade));
        return fornecedorDominio;

    }

}
