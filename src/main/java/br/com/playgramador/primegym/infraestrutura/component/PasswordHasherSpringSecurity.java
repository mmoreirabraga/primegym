package br.com.playgramador.primegym.infraestrutura.component;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.playgramador.primegym.negocio.port.PasswordHasher;

@Component
public class PasswordHasherSpringSecurity implements PasswordHasher{

    private final PasswordEncoder passwordEncoder;


    public PasswordHasherSpringSecurity(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String hash(String senhaPura) {
        return this.passwordEncoder.encode(senhaPura);
    }

    @Override
    public boolean matches(String senhaPura, String hashed) {
        return passwordEncoder.matches(senhaPura, hashed);
    }



}
