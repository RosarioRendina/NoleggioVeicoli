package org.generation.noleggio.dtos;

public class VeicoloDto {
	
	private int utente_id;
	private VeicoloCategoria categoria;
	private Integer anno;
	private String marca;
	private String modello;
	private String colore;
	private Integer cilindrata;
	private VeicoloAlimentazione alimentazione;
	private String indirizzo;
	private String coordinate;
	private boolean disponibilita;
	private String img_veicolo;
	
	public VeicoloDto() {
	}
	
	public VeicoloDto(int utente_id, VeicoloCategoria categoria, Integer anno, String marca, String modello,
			String colore, Integer cilindrata, VeicoloAlimentazione alimentazione, String indirizzo, String coordinate,
			boolean disponibilita, String img_veicolo) {
		this.utente_id = utente_id;
		this.categoria = categoria;
		this.anno = anno;
		this.marca = marca;
		this.modello = modello;
		this.colore = colore;
		this.cilindrata = cilindrata;
		this.alimentazione = alimentazione;
		this.indirizzo = indirizzo;
		this.coordinate = coordinate;
		this.disponibilita = disponibilita;
		this.img_veicolo = img_veicolo;
	}

	public int getUtente_id() {
		return utente_id;
	}

	public void setUtente_id(int utente_id) {
		this.utente_id = utente_id;
	}

	public VeicoloCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(VeicoloCategoria categoria) {
		this.categoria = categoria;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public Integer getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(Integer cilindrata) {
		this.cilindrata = cilindrata;
	}

	public VeicoloAlimentazione getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(VeicoloAlimentazione alimentazione) {
		this.alimentazione = alimentazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public boolean isDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}

	public String getImg_veicolo() {
		return img_veicolo;
	}

	public void setImg_veicolo(String img_veicolo) {
		this.img_veicolo = img_veicolo;
	}
	
}
