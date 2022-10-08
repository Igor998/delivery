package jwd56.test.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd56.test.model.Dostavljac;
import jwd56.test.web.dto.DostavljacDTO;

@Component
public class DostavljacToDostavljacDto implements Converter<Dostavljac, DostavljacDTO> {

	@Override
	public DostavljacDTO convert(Dostavljac source) {
		DostavljacDTO dto = new DostavljacDTO();
		
		dto.setId(source.getId());
		dto.setImePrezime(source.getImePrezime());

		return dto;
	}
	
	public List<DostavljacDTO> convert(List<Dostavljac> lista){
		return lista.stream().map(this::convert).collect(Collectors.toList());
	}
}
