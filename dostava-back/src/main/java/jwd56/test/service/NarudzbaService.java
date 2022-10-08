package jwd56.test.service;

import org.springframework.data.domain.Page;

import jwd56.test.model.Narudzba;

public interface NarudzbaService {

	Narudzba findOne(Long id);

	Page<Narudzba> search(String mestoIsporuke, Long dostavljacId, int pageNo);
	
	Narudzba save(Narudzba entitet);

	Narudzba update(Narudzba entitet);

	Narudzba delete(Long id);
}
