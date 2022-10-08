package jwd56.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd56.test.model.Racun;
import jwd56.test.repository.RacunRepository;
import jwd56.test.service.RacunService;

@Service
public class JpaRacunService implements RacunService {
	
	@Autowired
	private RacunRepository racunRepository;

	@Override
	public Racun findOne(Long id) {
		return racunRepository.findOneById(id);
	}

	@Override
	public List<Racun> findAll() {
		return racunRepository.findAll();
	}

	@Override
	public Racun save(Racun entitet) {
		return racunRepository.save(entitet);
	}

}
