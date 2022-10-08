package jwd56.test.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd56.test.model.Narudzba;
import jwd56.test.web.dto.NarudzbaDTO;

@Component
public class NarudzbaToNarudzbaDto implements Converter<Narudzba, NarudzbaDTO> {

	@Override
	public NarudzbaDTO convert(Narudzba source) {
		NarudzbaDTO dto = new NarudzbaDTO();
		
		dto.setId(source.getId());
		dto.setBrojNarudzbe(source.getBrojNarudzbe());
		dto.setDatumKreiranja(source.getDatumKreiranja());
		dto.setMestoIsporuke(source.getMestoIsporuke());
		dto.setCena(source.getCena());
		dto.setOpis(source.getOpis());
		dto.setDostavljacId(source.getDostavljac().getId());
		dto.setDostavljacImePrezime(source.getDostavljac().getImePrezime());
		
		if (source.getRacun() == null) {
			dto.setRacunId(-1L);
		} else {
			dto.setRacunId(source.getRacun().getId());
		}

		return dto;
	}
	
	public List<NarudzbaDTO> convert(List<Narudzba> lista){
		return lista.stream().map(this::convert).collect(Collectors.toList());
	}
}
