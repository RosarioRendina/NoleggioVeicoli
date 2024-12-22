package org.generation.noleggio.repositories;

import java.util.List;

import org.generation.noleggio.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Integer>{

//	List<Prenotazione> findAllByOrderByUtenteId();
//	List<Prenotazione> findAllByUtenteIdOrderByInizioPrenotazione(int utente_id);
	
	@Query(nativeQuery = true, value = "select * from Prenotazioni p where p.utente_id = ?1 ")
	List<Prenotazione> findByUtenteId(int utente_id);

	List<Prenotazione> findAllBy();
	
}
