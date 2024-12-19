package org.generation.noleggio.dtos;

import java.sql.Date;

public class UtenteDto {

	private int utente_id;
	private String nome;
	private String cognome;
	private Date data_nascita;
	private String email;
	private String password;
	private UtenteRuolo ruolo;

	public UtenteDto() {
	}

	public UtenteDto(int utente_id, String nome, String cognome, Date data_nascita, String email, String password,
			UtenteRuolo ruolo) {
		this.utente_id = utente_id;
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
	}

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
