package br.com.thiagomachadosguerrilistasrestapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.thiagomachadosguerrilistasrestapi.entities.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long>{
	
	List<ItemEntity> findAllByListas(Long idLista);

}
