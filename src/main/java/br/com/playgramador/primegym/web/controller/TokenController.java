package br.com.playgramador.primegym.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.playgramador.primegym.application.usecase.GeraTokenUsuarioUseCase;
import br.com.playgramador.primegym.web.dto.LoginRequest;
import br.com.playgramador.primegym.web.dto.LoginResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TokenController {

    private final GeraTokenUsuarioUseCase geraTokenUsuarioUseCase;

    public TokenController(GeraTokenUsuarioUseCase geraTokenUsuarioUseCase) {
        this.geraTokenUsuarioUseCase = geraTokenUsuarioUseCase;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        
        return ResponseEntity.ok(geraTokenUsuarioUseCase.execute(loginRequest));
    }
    
}
