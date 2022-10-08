package jwd56.test.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd56.test.model.Racun;
import jwd56.test.web.dto.RacunDTO;

@Component
public class RacunToRacunDto implements Converter<Racun, RacunDTO> {

	@Override
	public RacunDTO convert(Racun source) {
		RacunDTO dto = new RacunDTO();
		
		dto.setId(source.getId());
		dto.setBrojRacuna(source.getBrojRacuna());
		dto.setDatumKreiranja(source.getDatumKreiranja());
		dto.setUkupnaCena(source.getUkupnaCena());
		dto.setNarudzbaId(source.getNarudzba().getId());
		
		return dto;
	}
	
	public List<RacunDTO> convert(List<Racun> lista){
		return lista.stream().map(this::convert).collect(Collectors.toList());
	}
}
