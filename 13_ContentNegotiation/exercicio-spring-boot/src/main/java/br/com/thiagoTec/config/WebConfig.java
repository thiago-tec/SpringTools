package br.com.thiagoTec.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.thiagoTec.serialization.converter.YamlJackson2HttpMesageConverter;

@Configuration // <-- essa notação informa que quando o spring carregar a aplicação ele precisa ler
				// essa class que está as configuração sobre o comportamento da aplicação.
public class WebConfig implements WebMvcConfigurer {
	
	private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMesageConverter());
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		
		// https://www.baeldung.com/spring-mvc-content-negotiation-json-xml
		// Via EXTENSION. http://localhost:8080/api/person/v1.xml DEPRECATED on SpringBoot 2.6
		
		// Via QUERY PARAM. http://localhost:8080/api/person/v1?mediaType=xml
		/*
		configurer.favorParameter(true)//aceita parametros
		.parameterName("mediaType").ignoreAcceptHeader(true)//nome do parametro e ignora parametros no header true
		.useRegisteredExtensionsOnly(false)//determina se deve usar somente mapeamentos de MediaType registrados, porém está como false
		.defaultContentType(MediaType.APPLICATION_JSON)//padrão vai ser o json
			.mediaType("json", MediaType.APPLICATION_JSON) //defindo qual ele vai aceitar e qual o nome do parametro vai chamar ele
			.mediaType("xml", MediaType.APPLICATION_XML);
		*/
		
		
		// Via QUERY PARAM. http://localhost:8080/api/person/v1
		configurer.favorParameter(false)
		.ignoreAcceptHeader(false) 
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
			.mediaType("json", MediaType.APPLICATION_JSON) 
			.mediaType("xml", MediaType.APPLICATION_XML)
			.mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML)
			;
	}
	
}

