package org.generation.noleggio.services;

import java.util.List;

import org.generation.noleggio.entities.Veicolo;
import org.generation.noleggio.repositories.VeicoloRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeicoloServiceImpl implements VeicoloService{
	
	@Autowired
	VeicoloRepo veicoloRepository;
	
	@Override
	public List<Veicolo> prendiTutti() {
		List<Veicolo> veicoli = veicoloRepository.findAll();
		return veicoli;
	}
}
