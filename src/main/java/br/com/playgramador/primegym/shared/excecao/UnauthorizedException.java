package br.com.playgramador.primegym.shared.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends BusinessException{

    public UnauthorizedException(String chaveExcecao) {
        super(chaveExcecao);
    }

}
