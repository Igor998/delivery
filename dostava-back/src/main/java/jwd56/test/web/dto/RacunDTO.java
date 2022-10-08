package jwd56.test.web.dto;

import java.time.LocalDate;

public class RacunDTO {
	
	private Long id;
	
	private Integer brojRacuna;
	
	private LocalDate datumKreiranja;
	
	private Double ukupnaCena;
	
	private Long narudzbaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(Integer brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public LocalDate getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(LocalDate datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	public Double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(Double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public Long getNarudzbaId() {
		return narudzbaId;
	}

	public void setNarudzbaId(Long narudzbaId) {
		this.narudzbaId = narudzbaId;
	}
	
	
}
