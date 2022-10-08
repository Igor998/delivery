package jwd56.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd56.test.model.Dostavljac;
import jwd56.test.repository.DostavljacRepository;
import jwd56.test.service.DostavljacService;

@Service
public class JpaDostavljacService implements DostavljacService {

	@Autowired
	private DostavljacRepository dostavljacRepository;
	
	@Override
	public Dostavljac findOne(Long id) {
		return dostavljacRepository.findOneById(id);
	}

	@Override
	public List<Dostavljac> findAll() {
		return dostavljacRepository.findAll();
	}

}
