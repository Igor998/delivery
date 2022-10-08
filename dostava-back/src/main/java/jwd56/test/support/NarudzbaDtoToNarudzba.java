package jwd56.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd56.test.model.Dostavljac;
import jwd56.test.model.Narudzba;
import jwd56.test.service.DostavljacService;
import jwd56.test.service.NarudzbaService;
import jwd56.test.web.dto.NarudzbaDTO;

@Component
public class NarudzbaDtoToNarudzba implements Converter<NarudzbaDTO, Narudzba> {

	@Autowired
	private NarudzbaService narudzbaService;
	
	@Autowired
	private DostavljacService dostavljacService;
	
	@Override
	public Narudzba convert(NarudzbaDTO dto) {
		
		Narudzba entitet;
		
		if (dto.getId() == null) {
			entitet = new Narudzba();
		} else {
			entitet = narudzbaService.findOne(dto.getId());
		}
		
		if (entitet != null) {
			entitet.setBrojNarudzbe(dto.getBrojNarudzbe());
			entitet.setDatumKreiranja(dto.getDatumKreiranja());
			entitet.setMestoIsporuke(dto.getMestoIsporuke());
			entitet.setCena(dto.getCena());
			entitet.setOpis(dto.getOpis());
			
			Dostavljac dostavljac = dostavljacService.findOne(dto.getDostavljacId());
			entitet.setDostavljac(dostavljac);
		}
		return entitet;
    }

}