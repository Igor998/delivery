package jwd56.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jwd56.test.model.Dostavljac;
import jwd56.test.service.DostavljacService;
import jwd56.test.support.DostavljacToDostavljacDto;
import jwd56.test.web.dto.DostavljacDTO;

@RestController
@RequestMapping(value = "/dostavljaci", produces = MediaType.APPLICATION_JSON_VALUE)
public class DostavljacController {
	
	@Autowired
	private DostavljacToDostavljacDto toDto;
	
	@Autowired
	private DostavljacService service;

    @GetMapping
    public ResponseEntity<List<DostavljacDTO>> get(){

        List<Dostavljac> rezultat = service.findAll();

        return new ResponseEntity<>(toDto.convert(rezultat), HttpStatus.OK);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Void> handle() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
