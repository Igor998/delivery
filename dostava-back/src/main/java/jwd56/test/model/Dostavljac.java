package jwd56.test.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Dostavljac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String jmbg;
	
	@Column(unique = true, nullable = false)
	private String brojLK;
	
	@Column(nullable = false)
	private String imePrezime;
	
	@OneToMany(mappedBy = "dostavljac")
	private List<Narudzba> narudzbe = new ArrayList<Narudzba>();

	public Dostavljac() {
		super();
	}

	public Dostavljac(Long id, String jmbg, String brojLK, String imePrezime, List<Narudzba> narudzbe) {
		super();
		this.id = id;
		this.jmbg = jmbg;
		this.brojLK = brojLK;
		this.imePrezime = imePrezime;
		this.narudzbe = narudzbe;
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
		Dostavljac other = (Dostavljac) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getBrojLK() {
		return brojLK;
	}

	public void setBrojLK(String brojLK) {
		this.brojLK = brojLK;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public List<Narudzba> getNarudzbe() {
		return narudzbe;
	}

	public void setNarudzbe(List<Narudzba> narudzbe) {
		this.narudzbe = narudzbe;
	}
	
	
}
