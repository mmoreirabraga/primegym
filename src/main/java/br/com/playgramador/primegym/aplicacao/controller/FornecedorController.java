package br.com.playgramador.primegym.aplicacao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.playgramador.primegym.aplicacao.entrada.NovoFornecedor;
import br.com.playgramador.primegym.aplicacao.mapeador.AppFornecedorMapeador;
import br.com.playgramador.primegym.negocio.usecase.CadastraFornecedorUseCase;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final CadastraFornecedorUseCase cadastraFornecedorUseCase;
    private final AppFornecedorMapeador appFornecedorMapeador;

    public FornecedorController(CadastraFornecedorUseCase cadastraFornecedorUseCase,
            AppFornecedorMapeador appFornecedorMapeador) {
        this.cadastraFornecedorUseCase = cadastraFornecedorUseCase;
        this.appFornecedorMapeador = appFornecedorMapeador;
    }

    @PostMapping
    public ResponseEntity<String> salvaFornecedor(@Valid @RequestBody NovoFornecedor novoFornecedor) {
        this.cadastraFornecedorUseCase.execute(appFornecedorMapeador.paraDominio(novoFornecedor));
        return new ResponseEntity<>(String.format("%s salvo com sucesso!", novoFornecedor.razaoSocial()), HttpStatus.CREATED);  
    }

}
