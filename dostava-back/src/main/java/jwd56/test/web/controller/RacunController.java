package jwd56.test.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jwd56.test.model.Narudzba;
import jwd56.test.model.Racun;
import jwd56.test.service.NarudzbaService;
import jwd56.test.service.RacunService;
import jwd56.test.support.RacunDtoToRacun;
import jwd56.test.support.RacunToRacunDto;
import jwd56.test.web.dto.RacunDTO;

@RestController
@RequestMapping(value = "/racuni", produces = MediaType.APPLICATION_JSON_VALUE)
public class RacunController {
	
	@Autowired
	private RacunDtoToRacun fromDto;

	@Autowired
	private RacunToRacunDto toDto;
	
	@Autowired
	private RacunService service;
	
	@Autowired
	private NarudzbaService narudzbaService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RacunDTO> create(@RequestBody RacunDTO dto){
		Racun entitet = fromDto.convert(dto);
		Racun vrati = service.save(entitet);
		
		Narudzba nar = narudzbaService.findOne(vrati.getNarudzba().getId());
		nar.setRacun(vrati);
		narudzbaService.update(nar);
		
		return new ResponseEntity<RacunDTO>(toDto.convert(vrati), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RacunDTO> getOne(@PathVariable Long id){
		Racun entitet = service.findOne(id);
		
		if (entitet != null) {
			return new ResponseEntity<RacunDTO>(toDto.convert(entitet), HttpStatus.OK);
		} else {
			return new ResponseEntity<RacunDTO>(HttpStatus.NOT_FOUND);
		}
	}

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Void> handle() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
