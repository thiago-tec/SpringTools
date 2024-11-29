package br.com.thiagoTec.serialization.converter;


import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YamlJackson2HttpMesageConverter extends AbstractJackson2HttpMessageConverter {

	public YamlJackson2HttpMesageConverter() {
		super(
				new YAMLMapper()
					.setSerializationInclusion(//serializa todos os atributos até os nulos
							JsonInclude.Include.NON_NULL),//informando que até as não nulas devem ser serializadas
							MediaType.parseMediaType("application/x-yaml")
							);
	}

}
