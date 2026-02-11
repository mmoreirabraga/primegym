package br.com.playgramador.primegym.application.usecase;

import java.time.Instant;


import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.transaction.annotation.Transactional;

import br.com.playgramador.primegym.domain.model.Usuario;
import br.com.playgramador.primegym.domain.service.PoliticaSenha;
import br.com.playgramador.primegym.repo.UsuarioRepository;
import br.com.playgramador.primegym.shared.annotation.UseCase;
import br.com.playgramador.primegym.shared.excecao.UnauthorizedException;
import br.com.playgramador.primegym.web.dto.LoginRequest;
import br.com.playgramador.primegym.web.dto.LoginResponse;

@UseCase
public class GeraTokenUsuarioUseCase {
    
    private static String MEU_BACK_END = "primegym";
    
    private final UsuarioRepository usuarioRepository;
    private final PoliticaSenha politicaSenha;
    private final JwtEncoder jwtEncoder;

    public GeraTokenUsuarioUseCase(UsuarioRepository usuarioRepository, PoliticaSenha politicaSenha,
            JwtEncoder jwtEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.politicaSenha = politicaSenha;
        this.jwtEncoder = jwtEncoder;
    }

    @Transactional(readOnly = true)
    public LoginResponse execute(LoginRequest loginRequest) {

        var usuario = validaAutenticacao(loginRequest.usernameOrEmail(), loginRequest.senha());

        var agora = Instant.now();
        var expiraEm = 300L; // 5 minutos

        var claims = JwtClaimsSet.builder()
            .issuer(MEU_BACK_END) // meu back end que esta gerando
            .subject(usuario.getId().toString())
            .issuedAt(agora) // data de emissao do token
            .expiresAt(agora.plusSeconds(expiraEm))
            .build();

        var jwtValues = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();    
            return new LoginResponse(jwtValues, expiraEm);
    }

    private Usuario validaAutenticacao(String usernameOrEmail, String senha){

        var usuarioOpt = usuarioRepository.findByUsername(usernameOrEmail);

        if (usuarioOpt.isEmpty()) {
            usuarioOpt = usuarioRepository.findByEmail(usernameOrEmail);
        }
        
        var usuario = usuarioOpt.orElseThrow(
          () -> new UnauthorizedException("auth.credenciais_invalidas")
        );

        politicaSenha.validarSenhaAtravesLogin(senha, usuario.getSenha());

        return usuario;

    }
    


}
