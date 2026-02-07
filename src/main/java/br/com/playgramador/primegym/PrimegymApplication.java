package br.com.playgramador.primegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // <--- Ativa a auditoria : https://share.google/aimode/i7IzRUnzk5HMyX8Mk
public class PrimegymApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimegymApplication.class, args);
	}

}
