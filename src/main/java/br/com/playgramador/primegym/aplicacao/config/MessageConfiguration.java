package br.com.playgramador.primegym.aplicacao.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;

/**
 * Criar o arquivo de configuração para o spring recuperar estes arquivos de
 * mensagens, no caso iremos apenas utilizar o esquema de internacionalização do
 * spring.
 * 
 * @author Matheus Braga
 * @see https://dev.to/ledsonsilva/tratamento-de-erros-personalizados-para-apis-rest-com-spring-boot-4dpd
 */
@Configuration
public class MessageConfiguration {

    @Bean
    MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/messages/business/business", "classpath:/messages/validation/validation");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
    }

    @Bean
	LocalValidatorFactoryBean validator(MessageSource messageSource) {
		var bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource);
		return bean;
	}

    @Bean
	AcceptHeaderLocaleContextResolver localResolver() {
		var resolver = new AcceptHeaderLocaleContextResolver();
		resolver.setDefaultLocale(Locale.of("pt", "BR"));
		return resolver;
	}

}
