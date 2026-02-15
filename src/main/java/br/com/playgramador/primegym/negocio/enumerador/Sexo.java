package br.com.playgramador.primegym.negocio.enumerador;

public enum Sexo {

    M(1, "Masculino"), F(2, "Feminino");

    private final Integer codigo;
    private final String descricao;

    Sexo(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
