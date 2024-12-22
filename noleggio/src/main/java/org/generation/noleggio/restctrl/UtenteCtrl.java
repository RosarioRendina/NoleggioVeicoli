package org.generation.noleggio.restctrl;

import java.util.List;

import org.generation.noleggio.dtos.UtenteDto;
import org.generation.noleggio.entities.Utente;
import org.generation.noleggio.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/api/utente")
@CrossOrigin(origins = "localhost:5500")
public class UtenteCtrl {
	
	@Autowired
	UtenteService utenteService;
	
	@GetMapping
	public ResponseEntity<List<Utente>> getAll() {
		List<Utente> utenti = utenteService.prendiTutti();
		
		return ResponseEntity.ok(utenti);
	}
	
	/**
	 * Possibilità di registrazione di un utente <br>
	 * Richiede un json di un utente che abbia tutti i campi utili per la creazione: <br>
	 * Nome, Cognome, Email, Password, Ruolo.
	 * @param utente, richiesto negli headers con la POST
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> addOne(@RequestBody Utente utente) {

		try {
			UtenteDto dto = utenteService.aggiungi(utente);
			
			return ResponseEntity.ok(dto);  //200
			
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().body("Errore inserimento dati");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.internalServerError().body(new Utente());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Utente> getOneById(@PathVariable int id) {
		Utente utente = utenteService.cercaPerId(id);
		
		return ResponseEntity.ok(utente);
	}

	@GetMapping("/curr")
	public ResponseEntity<Utente> getCurrent(HttpSession session) {
		Utente check = (Utente) session.getAttribute("currentUser");
		if (check != null) {
			return ResponseEntity.ok(check);
		}
		return ResponseEntity.internalServerError().body(new Utente());
	}
		
}
