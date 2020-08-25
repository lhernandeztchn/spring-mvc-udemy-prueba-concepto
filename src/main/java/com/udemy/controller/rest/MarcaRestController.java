package com.udemy.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.controller.response.ErrorRestResponse;
import com.udemy.model.Marca;
import com.udemy.model.Modelo;
import com.udemy.service.IMarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaRestController {

	@Autowired
	IMarcaService service;

	@GetMapping(value = "/modelos/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getModelo(@PathVariable("id") Integer id) throws Exception {
		try {
			return new ResponseEntity<List<Modelo>>(service.listarPorId(id).getModelos(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ErrorRestResponse>(
					new ErrorRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMarca(@PathVariable("id") Integer id) throws Exception {
		try {
			return new ResponseEntity<Marca>(service.listarPorId(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ErrorRestResponse>(
					new ErrorRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(@RequestBody Marca marca) throws Exception {
		try {
			return new ResponseEntity<Integer>(service.modificar(marca), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ErrorRestResponse>(
					new ErrorRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}