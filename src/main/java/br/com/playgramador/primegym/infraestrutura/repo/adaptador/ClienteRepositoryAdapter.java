package br.com.playgramador.primegym.infraestrutura.repo.adaptador;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.playgramador.primegym.infraestrutura.mapeador.ClienteMapeador;
import br.com.playgramador.primegym.infraestrutura.repo.ClienteRepository;
import br.com.playgramador.primegym.negocio.dominio.ClienteDominio;
import br.com.playgramador.primegym.negocio.port.ClientePorta;

@Component
public class ClienteRepositoryAdapter implements ClientePorta{

    private final ClienteRepository clienteRepository;
    private final ClienteMapeador clienteMapeador;

    public ClienteRepositoryAdapter(ClienteRepository clienteRepository, ClienteMapeador clienteMapeador) {
        this.clienteRepository = clienteRepository;
        this.clienteMapeador = clienteMapeador;
    }

    @Override
    public boolean existeCpfCadastrado(String cpf) {
        return this.clienteRepository.existsByCpf(cpf);
    }

    @Override
    public ClienteDominio salvar(ClienteDominio cliente) {
        var clienteEntidade = clienteMapeador.paraEntidade(cliente);
        var clienteDominio = clienteMapeador.paraDominio(this.clienteRepository.save(clienteEntidade));
        
        return clienteDominio;
    }

    @Override
    public ClienteDominio atualizar(ClienteDominio cliente) {
        var clienteEntidade = this.clienteRepository.findById(cliente.getId()).get(); // como foi validado antes então não vai estourar erro

        clienteEntidade.setNomeCompleto(cliente.getNomeCompleto());
        clienteEntidade.setDataAniversario(cliente.getDataAniversario());
        clienteEntidade.setSexo(cliente.getSexo());

        return clienteMapeador.paraDominio(clienteEntidade);
    }

    @Override
    public Optional<ClienteDominio> buscarClientePeloId(Long id) {
        var clienteEntidade = this.clienteRepository.findById(id);

        return clienteEntidade.isPresent() ?
                                    Optional.ofNullable(clienteMapeador.paraDominio(clienteEntidade.get()))
                                    : Optional.empty();
    }

    @Override
    public boolean isIdExiste(Long id) {
        return this.clienteRepository.existsById(id);
    }

    @Override
    public void deletar(Long id) {
        this.clienteRepository.deleteById(id);
    }

}
