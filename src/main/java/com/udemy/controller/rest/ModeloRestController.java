package com.udemy.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.controller.response.ErrorRestResponse;
import com.udemy.service.IModeloService;

@RestController
@RequestMapping("/api/modelo")
public class ModeloRestController {

	@Autowired
	IModeloService service;

	@GetMapping(value = "/getCurrentId", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCurrentId() throws Exception {
		try {

			return new ResponseEntity<Integer>(service.currentId(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ErrorRestResponse>(
					new ErrorRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/get/codeModel/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> isCodeUsed(@PathVariable("code") String code) throws Exception {
		try {
			return new ResponseEntity<Boolean>(service.getByCodigo(code) == null ? false : true, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ErrorRestResponse>(
					new ErrorRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		try {
			int respuesta = service.eliminar(id);

			switch (respuesta) {
			case 0:
				return new ResponseEntity<Integer>(respuesta, HttpStatus.ACCEPTED);
			case 1:
				return new ResponseEntity<Integer>(respuesta, HttpStatus.OK);
			default:
				return new ResponseEntity<ErrorRestResponse>(
						new ErrorRestResponse(HttpStatus.FORBIDDEN.value(), "Denegado"), HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			return new ResponseEntity<ErrorRestResponse>(
					new ErrorRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}