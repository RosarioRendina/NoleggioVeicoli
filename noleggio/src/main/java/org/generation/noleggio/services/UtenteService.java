package org.generation.noleggio.services;

import java.util.List;

import org.generation.noleggio.dtos.UtenteDto;
import org.generation.noleggio.entities.Utente;

public interface UtenteService {

	// Teoricamente tutta la roba per quanto riguarda registrazione e forse login-logout
	// Eventuali permessi di accesso / modifica delle prenotazioni
	
	List<Utente> prendiTutti();
	
	// Registra Utente
	UtenteDto aggiungi(Utente utente);
	
	Utente cercaPerId(int id);
}
