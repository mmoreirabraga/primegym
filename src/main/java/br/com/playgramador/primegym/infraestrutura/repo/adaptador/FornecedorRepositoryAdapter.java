package br.com.playgramador.primegym.infraestrutura.repo.adaptador;

import java.util.Optional;

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

    @Override
    public FornecedorDominio atualizar(FornecedorDominio fornecedor) {

       var fornecedorEntidade = this.fornecedorRepository.findById(fornecedor.getId()).get(); // como foi validado antes então não vai estourar erro

       fornecedorEntidade.setNomeFantasia(fornecedor.getNomeFantasia());
       fornecedorEntidade.setRazaoSocial(fornecedor.getRazaoSocial());
        
       return fornecedorMapeador.paraDominio(fornecedorEntidade); 
    }

    @Override
    public Optional<FornecedorDominio> buscarFornecedorPeloId(Long id) {
        var fornecedorEntidade = this.fornecedorRepository.findById(id);

        return fornecedorEntidade.isPresent() ? 
                            Optional.ofNullable(fornecedorMapeador.paraDominio(fornecedorEntidade.get())) 
                            : Optional.empty();
    }

    @Override
    public boolean isIdExiste(Long id) {
        return this.fornecedorRepository.existsById(id);
    }
}
