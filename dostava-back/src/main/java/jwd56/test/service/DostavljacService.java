package jwd56.test.service;

import java.util.List;

import jwd56.test.model.Dostavljac;

public interface DostavljacService {

	Dostavljac findOne(Long id);

	List<Dostavljac> findAll();

}
