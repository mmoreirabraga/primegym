package br.com.playgramador.primegym.negocio.usecase;

import java.time.Instant;


import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.transaction.annotation.Transactional;

import br.com.playgramador.primegym.aplicacao.entrada.LoginResponse;
import br.com.playgramador.primegym.negocio.annotation.UseCase;
import br.com.playgramador.primegym.negocio.dominio.LoginRequestDominio;
import br.com.playgramador.primegym.negocio.service.PoliticaAutenticacao;

@UseCase
public class GeraTokenUsuarioUseCase {
    
    private static String MEU_BACK_END = "primegym";

    private final PoliticaAutenticacao politicaAutenticacao;
    private final JwtEncoder jwtEncoder;

    public GeraTokenUsuarioUseCase(PoliticaAutenticacao politicaAutenticacao, JwtEncoder jwtEncoder) {
        this.politicaAutenticacao = politicaAutenticacao;
        this.jwtEncoder = jwtEncoder;
    }

    @Transactional(readOnly = true)
    public LoginResponse execute(LoginRequestDominio loginRequest) {

        var usuario = politicaAutenticacao.validaAutenticacao(loginRequest.usernameOrEmail(), loginRequest.senha());

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

}
