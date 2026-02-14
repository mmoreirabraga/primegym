package br.com.playgramador.primegym.negocio.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends BusinessException{

    public ResourceNotFoundException(String chaveExcecao) {
        super(chaveExcecao);
    }

}
