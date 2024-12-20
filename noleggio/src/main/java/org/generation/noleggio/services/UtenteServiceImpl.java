package org.generation.noleggio.services;

import java.util.List;

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
	
	
	

}
