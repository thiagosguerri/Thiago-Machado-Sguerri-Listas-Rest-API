package br.com.thiagomachadosguerrilistasrestapi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiagomachadosguerrilistasrestapi.entities.ListaEntity;
import br.com.thiagomachadosguerrilistasrestapi.repositories.ListaRepository;

@Service
public class ListaService {
	
	@Autowired
	private ListaRepository listaRepository;

	
	@Transactional
	public ListaEntity cria(ListaEntity lista) {
		return listaRepository.save(lista);
	}
	
	@Transactional
	public ListaEntity altera(ListaEntity listaAlterada) {
		return listaRepository.save(listaAlterada);
	}
	
	@Transactional
	public void remover(ListaEntity lista) {
		listaRepository.delete(lista);		
	}
	
	@Transactional
	public ListaEntity buscaPorId(Long id) {
		return listaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Nenhuma lista encontrada do id: " + id));
	}

	public List<ListaEntity> listaTodos() {
		return listaRepository.findAll();
	}

}
