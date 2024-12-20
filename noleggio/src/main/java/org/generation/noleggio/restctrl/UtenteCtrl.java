package org.generation.noleggio.restctrl;

import java.util.List;

import org.generation.noleggio.dtos.UtenteDto;
import org.generation.noleggio.entities.Utente;
import org.generation.noleggio.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public ResponseEntity<?> addOne(@RequestBody Utente utente) {


		try {
			/* funziona per riferimento:
			 * l'utente arriva dal client senza id
			 * viene passato al service e poi al repository
			 * quando viene persistito / salvato mysql mette un id
			 * e me lo ritrovo valorizzato nell'oggetto */
			UtenteDto dto = utenteService.aggiungi(utente);
			
			return ResponseEntity.ok(dto);  //200
			
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().body("Errore inserimento dati");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.internalServerError().body(new Utente());
		}
	}
	

}
