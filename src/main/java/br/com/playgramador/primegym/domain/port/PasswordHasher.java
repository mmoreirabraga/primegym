package br.com.playgramador.primegym.domain.port;

public interface PasswordHasher {
    String hash(String senhaPura);
    boolean matches(String senhaPura, String hashed);
}
