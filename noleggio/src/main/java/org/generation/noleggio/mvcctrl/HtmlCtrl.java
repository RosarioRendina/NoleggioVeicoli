package org.generation.noleggio.mvcctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
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
	public String pannello() {
		return "pannello";
	}
	
	@GetMapping("/utente")
	public String utente() {
		return "utente";
	}
	
	@GetMapping("/veicolo")
	public String veicolo() {
		return "veicolo";
	}
	
}
