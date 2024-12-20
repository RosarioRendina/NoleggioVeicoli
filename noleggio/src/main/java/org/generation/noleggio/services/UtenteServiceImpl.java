package org.generation.noleggio.services;

import java.util.List;

import org.generation.noleggio.dtos.UtenteDto;
import org.generation.noleggio.entities.Utente;
import org.generation.noleggio.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService{
	
	@Autowired
	UtenteRepo utenteRepository;

	@Override
	public List<Utente> prendiTutti() {
		List<Utente> utenti = utenteRepository.findAll();
		return utenti;
	}

	@Override
	public UtenteDto aggiungi(Utente utente) {
		
		utenteRepository.save(utente);
		return this.toUtenteDto(utente);
	}
	
	private UtenteDto toUtenteDto(Utente utente) {
		UtenteDto utenteDto = new UtenteDto(
				utente.getUtente_id(),
				utente.getNome(),
				utente.getCognome(),
				utente.getData_nascita(),
				utente.getEmail(),
				"******",	// utente.getPassword()
				utente.getRuolo()
				);
		
		return utenteDto;
	}

}
