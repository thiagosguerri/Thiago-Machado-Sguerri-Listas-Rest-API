package br.com.thiagomachadosguerrilistasrestapi.dtos.output;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemOutput {
	
	private Long id;
	private String titulo;
	private Boolean concluido;
	private List<ListaOutput> listas;

}
