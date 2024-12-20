package org.generation.noleggio.entities;

import org.generation.noleggio.dtos.VeicoloAlimentazione;
import org.generation.noleggio.dtos.VeicoloCategoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "veicoli")
public class Veicolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int veicolo_id;
	
	@Column(columnDefinition = "ENUM('AUTO', 'SCOOTER', 'MOTO', 'FURGONE', 'MONOPATTINO', 'BICICLETTA', 'CAMMELLO')", nullable = false)
	@Enumerated(EnumType.STRING)
	private VeicoloCategoria categoria;
	
	@Column(nullable = true)
	private Integer anno;
	
	@Column(length = 50, nullable = false)
	private String marca;
	
	@Column(length = 50, nullable = true)
	private String modello;
	
	@Column(length = 20, nullable = true)
	private String colore;
	
	@Column(nullable = true)
	private Integer cilindrata;
	
	@Column(columnDefinition = "ENUM('ELETTRICA', 'BENZINA', 'DIESEL', 'GPL', 'IBRIDA')", nullable = true)
	@Enumerated(EnumType.STRING)
	private VeicoloAlimentazione alimentazione;
	
	@Column(length = 100, nullable = false)
	private String indirizzo;
	
	@Column(length = 100, nullable = true)
	private String coordinate;
	
	@Column(name = "disponibilita", nullable = false)
	private boolean disponibilita;
	
	@Column(length = 50, nullable = false)
	private String img_veicolo;

	public int getVeicolo_id() {
		return veicolo_id;
	}

	public void setVeicolo_id(int veicolo_id) {
		this.veicolo_id = veicolo_id;
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
