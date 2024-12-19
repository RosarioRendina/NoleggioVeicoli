package org.generation.noleggio.services;

import java.util.List;

import org.generation.noleggio.dtos.VeicoloDto;
import org.generation.noleggio.entities.Veicolo;

public interface VeicoloService {

	List<Veicolo> prendiTutti();

	Veicolo cercaPerId(int id);

	VeicoloDto aggiungi(Veicolo veicolo);
	
}
