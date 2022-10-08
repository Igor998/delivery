package jwd56.test.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Narudzba {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private Integer brojNarudzbe;
	
	@Column(nullable = false)
	private LocalDate datumKreiranja;
	
	@Column(nullable = false)
	private String mestoIsporuke;
	
	private Double cena;
	
	private String opis;
	
	@ManyToOne
	private Dostavljac dostavljac;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	private Racun racun;

	public Narudzba() {
		super();
	}

	public Narudzba(Long id, Integer brojNarudzbe, LocalDate datumKreiranja, String mestoIsporuke, Double cena,
			String opis, Dostavljac dostavljac, Racun racun) {
		super();
		this.id = id;
		this.brojNarudzbe = brojNarudzbe;
		this.datumKreiranja = datumKreiranja;
		this.mestoIsporuke = mestoIsporuke;
		this.cena = cena;
		this.opis = opis;
		this.dostavljac = dostavljac;
		this.racun = racun;
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
		Narudzba other = (Narudzba) obj;
		return Objects.equals(id, other.id);
	}

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

	public Dostavljac getDostavljac() {
		return dostavljac;
	}

	public void setDostavljac(Dostavljac dostavljac) {
		this.dostavljac = dostavljac;
	}

	public Racun getRacun() {
		return racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}
	
	
}
