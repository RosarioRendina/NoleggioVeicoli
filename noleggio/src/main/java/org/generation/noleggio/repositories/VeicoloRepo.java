package org.generation.noleggio.repositories;

import java.util.List;

import org.generation.noleggio.entities.Veicolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeicoloRepo extends JpaRepository<Veicolo, Integer>{

	List<Veicolo> findAllByOrderByCategoria();
	
}
