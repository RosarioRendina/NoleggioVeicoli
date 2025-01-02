package org.generation.noleggio.entities;

import java.sql.Date;

import org.generation.noleggio.dtos.StatoPrenotazione;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "veicolo_id", nullable = false)
	private Veicolo veicolo;
	
	@ManyToOne
	@JoinColumn(name = "utente_id", nullable = false)
	@JsonIgnore
	private Utente utente;
	
	@Column(name = "inizio_prenotazione", nullable = false)
	private Date inizioPrenotazione;
	
	@Column(name= "stato_prenotazione", columnDefinition = "ENUM('ELETTRICA', 'BENZINA', 'DIESEL', 'GPL', 'IBRIDA')", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatoPrenotazione statoPrenotazione;
	
	@Column(name = "fine_prenotazione", nullable = true)
	private Date finePrenotazione;

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
