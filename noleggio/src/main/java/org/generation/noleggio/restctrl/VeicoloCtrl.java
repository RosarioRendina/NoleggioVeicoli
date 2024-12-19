package org.generation.noleggio.restctrl;

import java.util.List;

import org.generation.noleggio.entities.Veicolo;
import org.generation.noleggio.services.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/veicolo")
public class VeicoloCtrl {

	@Autowired
	VeicoloService veicoloService;
	
	@GetMapping
	public ResponseEntity<List<Veicolo>> getAll() {
		List<Veicolo> veicoli = veicoloService.prendiTutti();
		
		return ResponseEntity.ok(veicoli);
	}
	
}
