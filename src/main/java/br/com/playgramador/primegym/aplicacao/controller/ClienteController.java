package br.com.playgramador.primegym.aplicacao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.playgramador.primegym.aplicacao.entrada.EditaCliente;
import br.com.playgramador.primegym.aplicacao.entrada.NovoCliente;
import br.com.playgramador.primegym.aplicacao.mapeador.AppClienteMapeador;
import br.com.playgramador.primegym.negocio.usecase.AtualizaClienteUseCase;
import br.com.playgramador.primegym.negocio.usecase.CadastraClienteUseCase;
import br.com.playgramador.primegym.negocio.usecase.DeletaClienteUseCase;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CadastraClienteUseCase cadastraClienteUseCase;
    private final AtualizaClienteUseCase atualizaClienteUseCase;
    private final DeletaClienteUseCase deletaClienteUseCase;
    private final AppClienteMapeador appClienteMapeador;

    
    public ClienteController(CadastraClienteUseCase cadastraClienteUseCase,
            AtualizaClienteUseCase atualizaClienteUseCase, DeletaClienteUseCase deletaClienteUseCase,
            AppClienteMapeador appClienteMapeador) {
        this.cadastraClienteUseCase = cadastraClienteUseCase;
        this.atualizaClienteUseCase = atualizaClienteUseCase;
        this.deletaClienteUseCase = deletaClienteUseCase;
        this.appClienteMapeador = appClienteMapeador;
    }
    



    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody NovoCliente cliente) {
        
        this.cadastraClienteUseCase.execute(appClienteMapeador.paraDomino(cliente));
        
        return new ResponseEntity<>(String.format("%s salvo com sucesso!", cliente.nomeCompleto()), HttpStatus.CREATED);  
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> editar(@PathVariable Long id, @Valid @RequestBody EditaCliente cliente) {
        
        this.atualizaClienteUseCase.execute(id, appClienteMapeador.paraDominio(cliente));
        
        return new ResponseEntity<>(String.format("%s editado com sucesso!", cliente.nomeCompleto()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        deletaClienteUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 

}
