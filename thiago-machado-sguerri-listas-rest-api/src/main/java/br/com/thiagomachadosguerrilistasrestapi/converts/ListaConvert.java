package br.com.thiagomachadosguerrilistasrestapi.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.thiagomachadosguerrilistasrestapi.dtos.input.ListaInput;
import br.com.thiagomachadosguerrilistasrestapi.dtos.output.ListaOutput;
import br.com.thiagomachadosguerrilistasrestapi.entities.ListaEntity;

@Component
public class ListaConvert {

	@Autowired
	private ModelMapper modelMapper;
	
	
	public ListaOutput entityToOutput(ListaEntity listaEntity) {
		return modelMapper.map(listaEntity, ListaOutput.class);
	}

	public List<ListaOutput> entityToOutput(List<ListaEntity> listasEntity) {
		return listasEntity.stream().map(lista -> this.entityToOutput(lista)).collect(Collectors.toList());
	}

	public ListaEntity inputToEntity(ListaInput listaInput) {
		return modelMapper.map(listaInput, ListaEntity.class);
	}

	public void copyDataInputToEntity(ListaInput listaInput, ListaEntity listaEntity) {
		modelMapper.map(listaInput, listaEntity);
	}
}
