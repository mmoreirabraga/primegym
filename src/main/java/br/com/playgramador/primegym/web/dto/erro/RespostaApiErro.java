package br.com.playgramador.primegym.web.dto.erro;

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
