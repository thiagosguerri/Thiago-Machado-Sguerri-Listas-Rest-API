package br.com.thiagomachadosguerrilistasrestapi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiagomachadosguerrilistasrestapi.entities.ItemEntity;
import br.com.thiagomachadosguerrilistasrestapi.repositories.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Transactional
	public ItemEntity cria(ItemEntity item) {
		return itemRepository.save(item);
	}
	
	@Transactional
	public ItemEntity altera(ItemEntity itemAlterado) {
		return itemRepository.save(itemAlterado);
	}
	
	@Transactional
	public void remover(ItemEntity item) {
		itemRepository.delete(item);		
	}
	
	@Transactional
	public ItemEntity buscaPorId(Long id) {
		return itemRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Nenhum item encontrada do id: " + id));
	}

	public List<ItemEntity> listaTodos() {
		return itemRepository.findAll();
	}
	
	public List<ItemEntity> listaItensPelaLista(Long idLista) {
		return itemRepository.findAllByListas(idLista);
	}

}
