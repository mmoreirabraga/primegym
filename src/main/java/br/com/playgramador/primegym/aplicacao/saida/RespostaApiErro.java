package br.com.playgramador.primegym.aplicacao.saida;

import java.time.LocalDateTime;
import java.util.Set;

public record RespostaApiErro(
        LocalDateTime dataResposta,
        Integer status,
        String codigo,
        Set<RespostaErro> erros
) {

    public RespostaApiErro {
        erros = Set.copyOf(erros);
    }

}
