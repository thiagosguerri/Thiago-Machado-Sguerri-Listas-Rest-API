package br.com.thiagomachadosguerrilistasrestapi.dtos.input;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemInput {
	
	@NotEmpty(message = "O campo Título é obrigatório!")
	@Length(message = "O campo Título deve ter no máximo 100 caracteres!", min = 1, max = 100)
	private String titulo;

	@NotEmpty(message = "O campo Lista é obrigatório!")
	private List<Long> listas;

}
