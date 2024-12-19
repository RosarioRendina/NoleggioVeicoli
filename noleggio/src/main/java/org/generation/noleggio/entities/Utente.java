package org.generation.noleggio.entities;

import java.sql.Date;

import org.generation.noleggio.dtos.UtenteRuolo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int utente_id;
	
	@Column(length = 75, nullable = true)
	private String nome;
	
	@Column(length = 75, nullable = true)
	private String cognome;
	
	@Column(nullable = true)
	private Date data_nascita;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(length = 20, nullable = false)
	private String password;
	
	@Column(columnDefinition = "ENUM('ADMIN', 'UTENTE')", nullable = false)
	@Enumerated(EnumType.STRING)
	private UtenteRuolo ruolo;

	public int getUtente_id() {
		return utente_id;
	}

	public void setUtente_id(int utente_id) {
		this.utente_id = utente_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UtenteRuolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(UtenteRuolo ruolo) {
		this.ruolo = ruolo;
	}
	
}
