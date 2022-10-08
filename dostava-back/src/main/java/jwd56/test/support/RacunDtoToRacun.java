package jwd56.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd56.test.model.Narudzba;
import jwd56.test.model.Racun;
import jwd56.test.service.NarudzbaService;
import jwd56.test.service.RacunService;
import jwd56.test.web.dto.RacunDTO;

@Component
public class RacunDtoToRacun implements Converter<RacunDTO, Racun> {

	@Autowired
	private RacunService racunService;
	
	@Autowired
	private NarudzbaService narudzbaService;
	
	@Override
	public Racun convert(RacunDTO dto) {
		
		Racun entitet;
		
		if (dto.getId() == null) {
			entitet = new Racun();
		} else {
			entitet = racunService.findOne(dto.getId());
		}
		
		if (entitet != null) {
			entitet.setBrojRacuna(dto.getBrojRacuna());
			entitet.setDatumKreiranja(dto.getDatumKreiranja());
			entitet.setUkupnaCena(dto.getUkupnaCena());
			
			Narudzba narudzba = narudzbaService.findOne(dto.getNarudzbaId());
			entitet.setNarudzba(narudzba);
		}
		return entitet;
	}
}