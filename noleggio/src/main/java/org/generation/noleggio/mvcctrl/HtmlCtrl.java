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
	
}
