package br.com.thiagomachadosguerrilistasrestapi.controllers;

import java.util.ArrayList;
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

import br.com.thiagomachadosguerrilistasrestapi.converts.ListaConvert;
import br.com.thiagomachadosguerrilistasrestapi.dtos.input.ListaInput;
import br.com.thiagomachadosguerrilistasrestapi.dtos.output.ListaOutput;
import br.com.thiagomachadosguerrilistasrestapi.entities.ItemEntity;
import br.com.thiagomachadosguerrilistasrestapi.entities.ListaEntity;
import br.com.thiagomachadosguerrilistasrestapi.services.ItemService;
import br.com.thiagomachadosguerrilistasrestapi.services.ListaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Lista")
@RestController
@RequestMapping("/api/listas")
@CrossOrigin(origins = "*")
public class ListaController {	

		@Autowired
		private ListaService listaService;
		
		@Autowired
		private ItemService itemService;
		
		@Autowired
		private ListaConvert listaConvert;

		@Operation(summary = "Cadastra lista", description = "Cadastra uma nova lista.")
		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		public ListaOutput criaLista(@Valid @RequestBody ListaInput lista) {
			ListaEntity listaEntity = listaConvert.inputToEntity(lista);

			ListaEntity listaCriada = listaService.cria(listaEntity);
			return listaConvert.entityToOutput(listaCriada);
		}
		
		@Operation(summary = "Altera lista cadastrada", description = "Altera uma lista cadastrada.")
		@PutMapping("/{id}")
		public ListaOutput alteraLista(@Parameter(description = "Id da Lista", example = "1")
		@PathVariable Long id, @Valid @RequestBody ListaInput listaInput) {
			ListaEntity listaEntity = listaService.buscaPorId(id);
			listaConvert.copyDataInputToEntity(listaInput, listaEntity);

			ListaEntity listaAlterada = listaService.altera(listaEntity);
			return listaConvert.entityToOutput(listaAlterada);
		}
		
		@Operation(summary = "Busca uma lista por id", description = "Lista uma lista por id cadastrado.")
		@GetMapping("/{id}")
		public ListaOutput buscaListaPorId(@PathVariable Long id) {
			ListaEntity listaEntity = listaService.buscaPorId(id);
			return listaConvert.entityToOutput(listaEntity);
		}
		
		@Operation(summary = "Busca todas as listas", description = "Lista todas as listas.")
		@GetMapping
		public List<ListaOutput> listaListas() {
			List<ListaEntity> listaTodos = listaService.listaTodos();
			return listaConvert.entityToOutput(listaTodos);
		}

		@DeleteMapping("/{id}")
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		public void removeLista(@PathVariable Long id) {
			ListaEntity listas = listaService.buscaPorId(id);
			listaService.remover(listas);
		}
		
		private void convertListas(ListaInput lista, ItemEntity itemEntity) {
			List<ItemEntity> itens = new ArrayList<>();
			for (Long listaId : lista.getListas()) {
				itens.add(itemService.buscaPorId(listaId));
			}
			itemEntity.setListas(itens);
		}

}
