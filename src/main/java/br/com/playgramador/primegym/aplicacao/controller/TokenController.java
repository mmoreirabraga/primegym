package br.com.playgramador.primegym.aplicacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.playgramador.primegym.aplicacao.entrada.LoginRequest;
import br.com.playgramador.primegym.aplicacao.mapeador.AppLoginMapeador;
import br.com.playgramador.primegym.aplicacao.saida.LoginResponse;
import br.com.playgramador.primegym.negocio.usecase.GeraTokenUsuarioUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TokenController {

    private final GeraTokenUsuarioUseCase geraTokenUsuarioUseCase;
    private final AppLoginMapeador appLoginMapeador;

    

    public TokenController(GeraTokenUsuarioUseCase geraTokenUsuarioUseCase, AppLoginMapeador appLoginMapeador) {
        this.geraTokenUsuarioUseCase = geraTokenUsuarioUseCase;
        this.appLoginMapeador = appLoginMapeador;
    }



    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        
        return ResponseEntity.ok(geraTokenUsuarioUseCase.execute(appLoginMapeador.paraDominio(loginRequest)));
    }
    
}
