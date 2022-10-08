package jwd56.test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd56.test.model.Narudzba;
import jwd56.test.service.NarudzbaService;
import jwd56.test.support.NarudzbaDtoToNarudzba;
import jwd56.test.support.NarudzbaToNarudzbaDto;
import jwd56.test.web.dto.NarudzbaDTO;

@RestController
@RequestMapping(value = "/narudzbe", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class NarudzbaController {
	
	@Autowired
	private NarudzbaDtoToNarudzba fromDto;

	@Autowired
	private NarudzbaToNarudzbaDto toDto;
	
	@Autowired
	private NarudzbaService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NarudzbaDTO> create(@Valid @RequestBody NarudzbaDTO dto){
		Narudzba entitet = fromDto.convert(dto);
		Narudzba vrati = service.save(entitet);
		
		return new ResponseEntity<NarudzbaDTO>(toDto.convert(vrati), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<NarudzbaDTO>> getAll(
			@RequestParam(required = false) String mestoIsporuke,
			@RequestParam(required = false) Long dostavljacId,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo
			){
		
		Page<Narudzba> rezultati = service.search(mestoIsporuke, dostavljacId, pageNo);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(rezultati.getTotalPages()));
		return new ResponseEntity<>(toDto.convert(rezultati.getContent()), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<NarudzbaDTO> getOne(@PathVariable Long id){
		Narudzba entitet = service.findOne(id);
		
		if (entitet != null) {
			return new ResponseEntity<NarudzbaDTO>(toDto.convert(entitet), HttpStatus.OK);
		} else {
			return new ResponseEntity<NarudzbaDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NarudzbaDTO> update(@PathVariable Long id, @Valid @RequestBody NarudzbaDTO dto){
		
		if (!id.equals(dto.getId())) {
			return new ResponseEntity<NarudzbaDTO>(HttpStatus.BAD_REQUEST);
		}
		
		Narudzba entitet = fromDto.convert(dto);
		Narudzba vrati = service.update(entitet);
		
		return new ResponseEntity<NarudzbaDTO>(toDto.convert(vrati), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		Narudzba obrisan = service.delete(id);
		
		if (obrisan != null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Void> handle() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
