package br.com.playgramador.primegym.aplicacao.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.playgramador.primegym.aplicacao.entrada.NovoUsuario;
import br.com.playgramador.primegym.aplicacao.mapeador.AppUsuarioMapeador;
import br.com.playgramador.primegym.negocio.usecase.CadastrarUsuarioUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final AppUsuarioMapeador appUsuarioMapeador;

   

    public UsuarioController(CadastrarUsuarioUseCase cadastrarUsuarioUseCase, AppUsuarioMapeador appUsuarioMapeador) {
        this.cadastrarUsuarioUseCase = cadastrarUsuarioUseCase;
        this.appUsuarioMapeador = appUsuarioMapeador;
    }



    @PostMapping
    public ResponseEntity<String> salvarUsuario(@Valid  @RequestBody NovoUsuario usuario) {
        this.cadastrarUsuarioUseCase.execute(appUsuarioMapeador.paraDominio(usuario));
        return new ResponseEntity<>(String.format("%s salvo com sucesso!", usuario.username()), HttpStatus.CREATED);        
    }
}
