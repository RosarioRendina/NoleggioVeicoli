package org.generation.noleggio.restctrl;

import java.util.List;


import org.generation.noleggio.dtos.VeicoloDto;
import org.generation.noleggio.entities.Veicolo;
import org.generation.noleggio.services.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Veicolo> getOneById(@PathVariable int id)
	{
		try {
			Veicolo v = veicoloService.cercaPerId(id);
			if(v != null)
			{
				return ResponseEntity.ok(v); //200				
			}else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Veicolo());
			}
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Veicolo());
		}
	}
	
	@PostMapping
//	public ResponseEntity<Utente> addOne(@RequestBody Utente utente)
	public ResponseEntity<?> addOne(@RequestBody Veicolo veicolo)
	{
		try {			
			//funziona per riferimento:
			//l'utente arriva dal client senza id
			//viene passato al service e poi al repository
			//quando viene persistito/salvato mysql mette un id
			// e me lo ritrovo valorizzato nell'oggetto
			VeicoloDto dto = veicoloService.aggiungi(veicolo); 
			

			return ResponseEntity.ok(dto); //200	
			
		}catch (DataIntegrityViolationException e)
		{
			return ResponseEntity.badRequest().body("Errore inserimento dati, controllare le proprietà dell'oggetto");
		}
		catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Veicolo());
		}
	}
}
