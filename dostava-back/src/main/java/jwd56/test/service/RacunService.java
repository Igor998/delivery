package jwd56.test.service;

import java.util.List;

import jwd56.test.model.Racun;

public interface RacunService {

	Racun findOne(Long id);

	List<Racun> findAll();
	
	Racun save(Racun entitet);
}
