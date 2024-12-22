package org.generation.noleggio.services;

import java.util.List;

import org.generation.noleggio.dtos.PrenotazioneDto;
import org.generation.noleggio.entities.Prenotazione;
import org.generation.noleggio.repositories.PrenotazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {
	
	@Autowired
	PrenotazioneRepo prenotazioneRepository;

	@Override
	public List<Prenotazione> prendiTutte() {
		List<Prenotazione> prenotazioni = prenotazioneRepository.findAll();
		return prenotazioni;
	}

	@Override
	public List<Prenotazione> prendiTuttePerUtenteId(int utenteId) {
		List<Prenotazione> prenotazioniUtente = prenotazioneRepository.findByUtenteId(utenteId);
		return prenotazioniUtente;
	}

	@Override
	public PrenotazioneDto aggiungi(Prenotazione prenotazione) {
		prenotazioneRepository.save(prenotazione);
		
		return this.toPrenotazioneDto(prenotazione);
	}
	
	private PrenotazioneDto toPrenotazioneDto(Prenotazione prenotazione) {
		
		PrenotazioneDto dto = new PrenotazioneDto(
				prenotazione.getId(),
				prenotazione.getInizioPrenotazione(), 
				prenotazione.isInCorso(), 
				prenotazione.getFinePrenotazione()
				);
		dto.setUtente(prenotazione.getUtente());
		dto.setVeicolo(prenotazione.getVeicolo());
		
		return dto;
	}

}
