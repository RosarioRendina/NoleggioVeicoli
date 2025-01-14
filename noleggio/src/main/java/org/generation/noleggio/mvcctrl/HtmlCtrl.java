package org.generation.noleggio.mvcctrl;

//import java.util.Optional;

import org.generation.noleggio.dtos.UtenteRuolo;
import org.generation.noleggio.entities.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("currentUser")	//-- serve solo se non uso HttpSession session
public class HtmlCtrl {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping({"/index", "/index.html", "/home"})
	public String r_home() {
		return "redirect:/";
	}
	
	
	@GetMapping("/errore.html")
	public String red_errore() {
		return "redirect:/errore";
	}
	
	@GetMapping("/errore")
	public String errore() {
		return "errore";
	}
	
	@GetMapping("inserisci.html")
	public String red_inserisci() {
		return "redirect:/inserisci";
	}
		
	@GetMapping("/inserisci")
	public String inserisci() {
		return "inserisci";
	}
	
	@GetMapping("/pannello")
	public String pannello(HttpSession session) {
		
//		Optional<Object> currentUser = Optional.of(session.getAttribute("currentUser"));
		Utente currentUser = (Utente) session.getAttribute("currentUser");
		
		if (currentUser != null) {
//			Utente utente = (Utente) currentUser.get();
			
			return (currentUser.getRuolo() == UtenteRuolo.ADMIN) ? "pannello" : "redirect:/errore";
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping({"/utente", "/utente.html"})
	public String utente(HttpSession session) {
		
//		Optional<Object> currentUser = Optional.of(session.getAttribute("currentUser"));
//		Utente currentUser = (Utente) session.getAttribute("currentUser");
//		if (currentUser.isEmpty()) {
//			return "redirect:/login";
//		}
		Utente currentUser = (Utente) session.getAttribute("currentUser");
		
		if (currentUser == null) {
			return "redirect:/login";
		}
		
		return "utente";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/login.html")
	public String red_login() {
		return "redirect:/login";
	}
	
	@GetMapping("/veicolo")
	public String veicolo(@RequestParam("id") long id) {
		return "veicolo";
	}
	
}
