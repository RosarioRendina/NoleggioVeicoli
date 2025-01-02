package org.generation.noleggio.dtos;

import java.sql.Date;

import org.generation.noleggio.entities.Utente;
import org.generation.noleggio.entities.Veicolo;


public class PrenotazioneDto {

	private Long id;
	private Veicolo veicolo;
	private Utente utente;
	private Date inizioPrenotazione;
	private StatoPrenotazione statoPrenotazione;
	private Date finePrenotazione;
	
	public PrenotazioneDto() {
	}

	public PrenotazioneDto(Long id, Date inizioPrenotazione, StatoPrenotazione statoPrenotazione,
			Date finePrenotazione) {
		this.id = id;
		this.inizioPrenotazione = inizioPrenotazione;
		this.statoPrenotazione = statoPrenotazione;
		this.finePrenotazione = finePrenotazione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Veicolo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Date getInizioPrenotazione() {
		return inizioPrenotazione;
	}

	public void setInizioPrenotazione(Date inizioPrenotazione) {
		this.inizioPrenotazione = inizioPrenotazione;
	}

	public Date getFinePrenotazione() {
		return finePrenotazione;
	}

	public void setFinePrenotazione(Date finePrenotazione) {
		this.finePrenotazione = finePrenotazione;
	}

	public StatoPrenotazione getStatoPrenotazione() {
		return statoPrenotazione;
	}

	public void setStatoPrenotazione(StatoPrenotazione statoPrenotazione) {
		this.statoPrenotazione = statoPrenotazione;
	}

	
}
