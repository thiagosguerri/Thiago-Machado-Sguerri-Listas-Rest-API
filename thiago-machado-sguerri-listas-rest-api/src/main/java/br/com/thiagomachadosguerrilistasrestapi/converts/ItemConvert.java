package br.com.thiagomachadosguerrilistasrestapi.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.thiagomachadosguerrilistasrestapi.dtos.input.ItemInput;
import br.com.thiagomachadosguerrilistasrestapi.dtos.output.ItemOutput;
import br.com.thiagomachadosguerrilistasrestapi.entities.ItemEntity;

@Component
public class ItemConvert {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ItemOutput entityToOutput(ItemEntity itemEntity) {
		return modelMapper.map(itemEntity, ItemOutput.class);
	}

	public List<ItemOutput> entityToOutput(List<ItemEntity> itensEntity) {
		return itensEntity.stream().map(item -> this.entityToOutput(item)).collect(Collectors.toList());
	}

	public ItemEntity inputToEntity(ItemInput itemInput) {
		return modelMapper.map(itemInput, ItemEntity.class);
	}

	public void copyDataInputToEntity(ItemInput itemInput, ItemEntity itemEntity) {
		modelMapper.map(itemInput, itemEntity);
	}
	
}
