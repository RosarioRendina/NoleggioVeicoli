package org.generation.noleggio.mvcctrl;

import java.util.Optional;

import org.generation.noleggio.dtos.UtenteRuolo;
import org.generation.noleggio.entities.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
//@SessionAttributes("currentUser")	-- serve solo se non uso HttpSession session
public class HtmlCtrl {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/test")
	public String test() {
		return "prova";
	}
	/* EVENTUALE REMAPPING PAGINE */
	
	@GetMapping("/errore")
	public String errore() {
		return "errore";
	}
	
	@GetMapping("/inserisci")
	public String inserisci() {
		return "inserisci";
	}
	
	@GetMapping("/pannello")
	public String pannello(HttpSession session) {
		
		Optional<Object> currentUser = Optional.of(session.getAttribute("currentUser"));
		
		if (currentUser.isPresent()) {
			Utente utente = (Utente) currentUser.get();
			
			return (utente.getRuolo() == UtenteRuolo.UTENTE) ? "errore" : "pannello";
		} else {
			return "login";
		}
	}
	
	@GetMapping("/utente")
	public String utente(HttpSession session) {
		
		Optional<Object> currentUser = Optional.of(session.getAttribute("currentUser"));
//		Utente currentUser = (Utente) session.getAttribute("currentUser");
		if (currentUser.isEmpty()) {
			return "login";
		}
		return "utente";
	}
	
	@GetMapping("/veicolo")
	public String veicolo() {
		return "veicolo";
	}
	
}
