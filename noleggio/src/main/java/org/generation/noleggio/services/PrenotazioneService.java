package org.generation.noleggio.services;

import java.util.List;

import org.generation.noleggio.dtos.PrenotazioneDto;
import org.generation.noleggio.entities.Prenotazione;

public interface PrenotazioneService {
	
	List<Prenotazione> prendiTutte();

	List<Prenotazione> prendiTuttePerUtenteId(int utenteId);
	
	PrenotazioneDto aggiungi(Prenotazione prenotazione);
	
}
