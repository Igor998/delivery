package jwd56.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd56.test.model.Dostavljac;

@Repository
public interface DostavljacRepository extends JpaRepository<Dostavljac, Long> {
	
	Dostavljac findOneById(Long id);
}