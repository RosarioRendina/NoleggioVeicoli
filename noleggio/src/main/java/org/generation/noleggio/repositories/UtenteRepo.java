package org.generation.noleggio.repositories;

import java.util.List;

import org.generation.noleggio.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepo extends JpaRepository<Utente, Integer>{

	List<Utente> findAllByOrderByCognome();
	
}