package jwd56.test.web.dto;

import java.time.LocalDate;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class NarudzbaDTO {
	
	private Long id;
	
	@Positive
	private Integer brojNarudzbe;
	
	private LocalDate datumKreiranja;
	
	@Length(max = 50)
	private String mestoIsporuke;
	
	private Double cena;
	
	private String opis;
	
	private Long dostavljacId;
	
	private String dostavljacImePrezime;
	
	private Long racunId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBrojNarudzbe() {
		return brojNarudzbe;
	}

	public void setBrojNarudzbe(Integer brojNarudzbe) {
		this.brojNarudzbe = brojNarudzbe;
	}

	public LocalDate getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(LocalDate datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	public String getMestoIsporuke() {
		return mestoIsporuke;
	}

	public void setMestoIsporuke(String mestoIsporuke) {
		this.mestoIsporuke = mestoIsporuke;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Long getDostavljacId() {
		return dostavljacId;
	}

	public void setDostavljacId(Long dostavljacId) {
		this.dostavljacId = dostavljacId;
	}

	public Long getRacunId() {
		return racunId;
	}

	public void setRacunId(Long racunId) {
		this.racunId = racunId;
	}

	public String getDostavljacImePrezime() {
		return dostavljacImePrezime;
	}

	public void setDostavljacImePrezime(String dostavljacImePrezime) {
		this.dostavljacImePrezime = dostavljacImePrezime;
	}
	
	
}
