package br.com.playgramador.primegym.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.playgramador.primegym.application.usecase.CadastrarUsuarioUseCase;
import br.com.playgramador.primegym.web.dto.NovoUsuario;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    public UsuarioController(CadastrarUsuarioUseCase cadastrarUsuarioUseCase) {
        this.cadastrarUsuarioUseCase = cadastrarUsuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<String> salvarUsuario(@Valid  @RequestBody NovoUsuario usuario) {
        this.cadastrarUsuarioUseCase.execute(usuario);
        return ResponseEntity.ok(String.format("%s salvo com sucesso!", usuario.username()));        
    }
}
