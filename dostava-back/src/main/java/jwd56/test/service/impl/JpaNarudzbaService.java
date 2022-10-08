package jwd56.test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd56.test.model.Narudzba;
import jwd56.test.repository.NarudzbaRepository;
import jwd56.test.service.NarudzbaService;

@Service
public class JpaNarudzbaService implements NarudzbaService {

	@Autowired
	private NarudzbaRepository narudzbaRepository;
	
	
	@Override
	public Narudzba findOne(Long id) {
		return narudzbaRepository.findOneById(id);
	}

	@Override
	public Page<Narudzba> search(String mestoIsporuke, Long dostavljacId,int pageNo) {

		if (mestoIsporuke == null) {
			mestoIsporuke = "";
		}
		
		if (dostavljacId == null) {
			return narudzbaRepository.findByMestoIsporukeIgnoreCaseContains(mestoIsporuke, PageRequest.of(pageNo, 3));
		} else {
			return narudzbaRepository.findByMestoIsporukeIgnoreCaseContainsAndDostavljacId(mestoIsporuke, dostavljacId, PageRequest.of(pageNo, 3));
		}
	}

	@Override
	public Narudzba save(Narudzba entitet) {
		return narudzbaRepository.save(entitet);
	}

	@Override
	public Narudzba update(Narudzba entitet) {
		return narudzbaRepository.save(entitet);
	}

	@Override
	public Narudzba delete(Long id) {
		Optional<Narudzba> opt = narudzbaRepository.findById(id);
		if (opt.isPresent()) {
			narudzbaRepository.deleteById(id);
			return opt.get();
		}
		return null;
	}

}
