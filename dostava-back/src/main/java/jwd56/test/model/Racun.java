package jwd56.test.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Racun {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private Integer brojRacuna;
	
	@Column(nullable = false)
	private LocalDate datumKreiranja;
	
	@Column(nullable = false)
	private Double ukupnaCena;
	
	@OneToOne
	private Narudzba narudzba;

	public Racun() {
		super();
	}

	public Racun(Long id, Integer brojRacuna, LocalDate datumKreiranja, Double ukupnaCena, Narudzba narudzba) {
		super();
		this.id = id;
		this.brojRacuna = brojRacuna;
		this.datumKreiranja = datumKreiranja;
		this.ukupnaCena = ukupnaCena;
		this.narudzba = narudzba;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Racun other = (Racun) obj;
		return Objects.equals(id, other.id);
	}

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

	public Narudzba getNarudzba() {
		return narudzba;
	}

	public void setNarudzba(Narudzba narudzba) {
		this.narudzba = narudzba;
	}
	

}
