package br.com.playgramador.primegym.negocio.excecao;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/***
 * Exceção que vai tratar erros de negocio da aplicação
 */
@ResponseStatus(code = HttpStatus.UNPROCESSABLE_CONTENT)
public class BusinessException extends BaseRuntimeException{

    private static final long serialVersionUID = 1L;
	
	private final String chaveExcecao;

    /**
	 * Eu precise passar a chave para identificar qual é a mensagem será chamada na business.properties
	 * @param exceptionKey
	 */
	public BusinessException(String chaveExcecao) {
		super();
		this.chaveExcecao = chaveExcecao;
	}
	
	/**
	 * Eu precise passar a chave para identificar qual é a mensagem será chamada na business.properties e o valor que ficará na mensagem
	 * @param exceptionKey
	 */
	public BusinessException(String chaveExcecao, String value) {
		super(Map.of("value", value));
		this.chaveExcecao = chaveExcecao;
	}
	
	@Override
    public String getChaveExcecao() {
        return this.chaveExcecao;
    }

}
