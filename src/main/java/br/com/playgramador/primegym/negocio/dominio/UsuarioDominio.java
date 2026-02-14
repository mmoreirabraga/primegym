package br.com.playgramador.primegym.negocio.dominio;

import java.util.UUID;

public class UsuarioDominio {

    private UUID id;
    
    private String username;

    private String email;

    private String senha;

    private String confirmaSenha;

    public UsuarioDominio() {
    }

    public UsuarioDominio(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UsuarioDominio(UUID id, String username, String email, String senha, String confirmaSenha) {
        this(username, email);
        this.id = id;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsuarioDominio other = (UsuarioDominio) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    
}
