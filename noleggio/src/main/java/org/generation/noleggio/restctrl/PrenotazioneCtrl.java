package org.generation.noleggio.restctrl;

import java.util.List;

import org.generation.noleggio.entities.Prenotazione;
import org.generation.noleggio.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "localhost:5500")
@RequestMapping("/api/prenotazione")
public class PrenotazioneCtrl {
	
	@Autowired
	PrenotazioneService prenotazioneService;
	
	@GetMapping
	public ResponseEntity<List<Prenotazione>> getAll() {
		List<Prenotazione> prenotazioni = prenotazioneService.prendiTutte();
		
		return ResponseEntity.ok(prenotazioni);
	}
	
	@GetMapping("/{utente_id}")
	public ResponseEntity<List<Prenotazione>> getAllForUtente(@PathVariable("utente_id") int id) {
		List<Prenotazione> prenotazioni = prenotazioneService.prendiTuttePerUtenteId(id);
		
		return ResponseEntity.ok(prenotazioni);
	}

}
