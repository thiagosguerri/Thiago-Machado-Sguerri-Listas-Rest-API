package br.com.thiagomachadosguerrilistasrestapi.controllers;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagomachadosguerrilistasrestapi.converts.ItemConvert;
import br.com.thiagomachadosguerrilistasrestapi.dtos.input.ItemInput;
import br.com.thiagomachadosguerrilistasrestapi.dtos.output.ItemOutput;
import br.com.thiagomachadosguerrilistasrestapi.entities.ItemEntity;
import br.com.thiagomachadosguerrilistasrestapi.services.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Item")
@RestController
@RequestMapping("/api/itens")
@CrossOrigin(origins = "*")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemConvert itemConvert;
	
	@Operation(summary = "Cadastra item", description = "Cadastra um novo item.")
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItemOutput criaItem(@Valid @RequestBody ItemInput item) throws URISyntaxException{
		ItemEntity itemEntity = itemConvert.inputToEntity(item);
		
		ItemEntity itemCriado = itemService.cria(itemEntity);
		return itemConvert.entityToOutput(itemCriado);
	}
	
	@Operation(summary = "Altera item cadastrado", description = "Altera uma item cadastrado.")
	@PutMapping("/{id}")
	public ItemOutput alteraItem(@Parameter(description = "Id do Item", example = "1")
	@PathVariable Long id, @Valid @RequestBody ItemInput itemInput) {
		ItemEntity itemEntity = itemService.buscaPorId(id);
		itemConvert.copyDataInputToEntity(itemInput, itemEntity);
		
		ItemEntity itemAlterado = itemService.altera(itemEntity);
		return itemConvert.entityToOutput(itemAlterado);
	}
	
	@Operation(summary = "Busca item por id", description = "Busca item por id cadsatrado.")
	@GetMapping("/{id}")
	public ItemOutput buscaItemPorId(@PathVariable Long id) {
		ItemEntity itemEntity = itemService.buscaPorId(id);
		return itemConvert.entityToOutput(itemEntity);
	}

	@Operation(summary = "Lista itens", description = "Lista todos os itens cadastrados.")
	@GetMapping
	public List<ItemOutput> listaItens() {
		List<ItemEntity> listaTodos = itemService.listaTodos();
		return itemConvert.entityToOutput(listaTodos);
	}
	
	@Operation(summary = "Exclui item", description = "Remove o item cadastrado.")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable Long id) {
		ItemEntity itemEntity = itemService.buscaPorId(id);
		itemService.remover(itemEntity);
	}

}
