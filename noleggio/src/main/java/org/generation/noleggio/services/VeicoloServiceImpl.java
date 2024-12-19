package org.generation.noleggio.services;

import java.util.List;

import org.generation.noleggio.dtos.VeicoloDto;
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


	@Override
	public Veicolo cercaPerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VeicoloDto aggiungi(Veicolo veicolo) {
		// TODO Auto-generated method stub
		return null;
	}
}
