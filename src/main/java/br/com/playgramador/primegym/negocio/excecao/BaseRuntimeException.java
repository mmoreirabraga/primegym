package br.com.playgramador.primegym.negocio.excecao;

import java.util.Map;

import br.com.playgramador.primegym.negocio.excecao.contrato.MessageException;

public abstract class BaseRuntimeException extends RuntimeException implements MessageException{

    private static final long serialVersionUID = 1L;

    private final transient Map<String, Object> mapDetalhes;

    protected BaseRuntimeException() {
        this.mapDetalhes = null;
    }

    protected BaseRuntimeException(final Map<String, Object> mapDetalhes) {
        this.mapDetalhes = mapDetalhes;
    }

    @Override
    public Map<String, Object> getMapDetalhes() {
        return this.mapDetalhes;
    }




}
