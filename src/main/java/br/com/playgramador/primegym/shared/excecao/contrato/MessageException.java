package br.com.playgramador.primegym.shared.excecao.contrato;

import java.util.Map;

public interface MessageException {

    String getChaveExcecao();
    Map<String, Object> getMapDetalhes();
}
