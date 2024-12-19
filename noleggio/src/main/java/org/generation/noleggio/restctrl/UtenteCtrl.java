package org.generation.noleggio.restctrl;

import java.util.List;

import org.generation.noleggio.entities.Utente;
import org.generation.noleggio.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/utente")
public class UtenteCtrl {
	
	@Autowired
	UtenteService utenteService;
	
	@GetMapping
	public ResponseEntity<List<Utente>> getAll() {
		List<Utente> utenti = utenteService.prendiTutti();
		
		return ResponseEntity.ok(utenti);
	}
	

}
