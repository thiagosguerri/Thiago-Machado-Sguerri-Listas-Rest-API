package br.com.thiagomachadosguerrilistasrestapi.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI springOpenAPI() {

		OpenAPI openAPI = new OpenAPI();
		
		Info info = new Info();
		info.title("Listas - Avaliação 3");
		info.version("v0.0.1");
		info.description("<h3> Esta é uma aplicação de listas </h3>");

		openAPI.info(info);
		
		openAPI.info(info);

		openAPI.addTagsItem(new Tag().name("Lista").description("Gerencia as listas do sistema"));
		openAPI.addTagsItem(new Tag().name("Item").description("Gerencia os itens do sistema"));
		
		return openAPI;
	}
}
	
