package br.com.thiagomachadosguerrilistasrestapi.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_itens")
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, name = "titulo")
	private String titulo;
	
	@Column(nullable = true || false, name = "concluido")
	private Boolean concluido;
	
	@OneToMany
	@JoinTable(name = "tb_itens_listas", joinColumns = @JoinColumn(name = "listas_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "itens_id", referencedColumnName = "id"))
	private List<ListaEntity> listas;

	public void setListas(List<ItemEntity> itens) {
		// TODO Auto-generated method stub
		
	}

}
