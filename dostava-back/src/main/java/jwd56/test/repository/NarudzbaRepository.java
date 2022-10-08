package jwd56.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd56.test.model.Narudzba;

@Repository
public interface NarudzbaRepository extends JpaRepository<Narudzba, Long> {
	
	Narudzba findOneById(Long id);
	
	Page<Narudzba> findByMestoIsporukeIgnoreCaseContainsAndDostavljacId(
			String mestoIsporuke, Long dostavljacId, Pageable pageable
			);
	
	Page<Narudzba> findByMestoIsporukeIgnoreCaseContains(
			String mestoIsporuke, Pageable pageable
			);

}