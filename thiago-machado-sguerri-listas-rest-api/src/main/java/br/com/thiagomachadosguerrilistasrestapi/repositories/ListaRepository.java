package br.com.thiagomachadosguerrilistasrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.thiagomachadosguerrilistasrestapi.entities.ListaEntity;

@Repository

public interface ListaRepository extends JpaRepository<ListaEntity, Long>{

}
