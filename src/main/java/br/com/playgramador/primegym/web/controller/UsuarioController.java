package br.com.playgramador.primegym.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.playgramador.primegym.application.usecase.CadastrarUsuarioUseCase;
import br.com.playgramador.primegym.domain.port.UsuarioRepository;
import br.com.playgramador.primegym.web.dto.NovoUsuario;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(CadastrarUsuarioUseCase cadastrarUsuarioUseCase, UsuarioRepository usuarioRepository) {
        this.cadastrarUsuarioUseCase = cadastrarUsuarioUseCase;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<String> salvarUsuario(@Valid  @RequestBody NovoUsuario usuario) {
        this.cadastrarUsuarioUseCase.execute(usuario);
        // quando salvou o usuairo significa que o username exista na base de dados, fazendo com que seja seguro chamar .get() do optinal sem lançar o erro
        var usuarioSalvo = usuarioRepository.findByUsername(usuario.username()).get();
        return ResponseEntity.ok(String.format("%s salvo com sucesso!", usuarioSalvo.getUsername()));        
    }
}
