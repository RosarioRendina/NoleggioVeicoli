package org.generation.noleggio.restctrl;

import org.generation.noleggio.dtos.UtenteDto;
import org.generation.noleggio.entities.Utente;
import org.generation.noleggio.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("test")
@SessionAttributes("currentUser")  // a login effettuato -> currentUser = emailUtente (o utente.getEmail())
public class LoginCtrl {

	@Autowired
	private UtenteRepo utenteRepository;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UtenteDto utenteDto, HttpSession session) {
		Utente utente = utenteRepository.findByEmail(utenteDto.getEmail())
				.orElse(null);
		
		if (utente != null && utente.getPassword().equals(utenteDto.getPassword())) {
			session.setAttribute("currentUser", utente);
			return ResponseEntity.ok("Login effettuato con successo");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenziali non valide.");
		}
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok("Logout effettuato con successo");
	}
	
	@GetMapping("/protected")
	public ResponseEntity<String> testProtected(HttpSession session) {
		Utente currentUser = (Utente) session.getAttribute("currentUser");
		
		if (currentUser == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Devi essere loggato per accedere");
		}
		
		return ResponseEntity.ok("Benvenuto, " + currentUser.getNome() + " - Questa è una risorsa protetta.");
	}
	
}
