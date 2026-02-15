package br.com.playgramador.primegym.aplicacao.entrada;

import java.time.LocalDate;

import br.com.playgramador.primegym.negocio.enumerador.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public record EditaCliente(
    @NotBlank(message = "{campo.obrigatorio}")
    @Size(min = 2, max = 255, message = "{tamanho_dado_campo}")
    String nomeCompleto,
    @Past(message = "{data_passado}")
    LocalDate dataAniversario,
    @NotNull(message = "{campo.obrigatorio}")
    Sexo sexo
) {

}
