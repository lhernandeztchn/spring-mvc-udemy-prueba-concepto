package com.udemy.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.controller.response.ErrorRestRresponse;
import com.udemy.model.Modelo;
import com.udemy.service.IModeloService;

@RestController
@RequestMapping("/api/modelo")
public class ModeloRestController {

	@Autowired
	IModeloService service;

	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<Integer>(service.eliminar(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ErrorRestRresponse>(
					new ErrorRestRresponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/eliminar/lista/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteList(@PathVariable("codigo") String codigo) {
		try {
			return new ResponseEntity<Integer>(service.eliminarModeloFromList(codigo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ErrorRestRresponse>(
					new ErrorRestRresponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getModeloList() {
		try {
			return new ResponseEntity<List<Modelo>>(service.getModelos(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ErrorRestRresponse>(
					new ErrorRestRresponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/agregar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(@RequestBody Modelo modelo) throws Exception {
		try {
			return new ResponseEntity<Integer>(service.agergar(modelo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ErrorRestRresponse>(
					new ErrorRestRresponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}