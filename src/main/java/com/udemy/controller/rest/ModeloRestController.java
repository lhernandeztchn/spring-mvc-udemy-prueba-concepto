package com.udemy.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.controller.response.ErrorRestResponse;
import com.udemy.model.Modelo;
import com.udemy.service.IMarcaService;
import com.udemy.service.IModeloService;

@RestController
@RequestMapping("/api/modelo")
public class ModeloRestController {

	@Autowired
	IModeloService service;

	@Autowired
	IMarcaService marcaService;

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

//	@GetMapping("/getModelosByMarca")
//	public  Map<String, String> getStateCityValues(@RequestParam("modelo.marca") Integer idMarca) {
//		Map<String, String> modelosValues = new HashMap<>();
//		List<Modelo> modelos = marcaService.listarPorId(idMarca).getModelos();
//
//		modelos.forEach(modelo -> modelosValues.put(String.valueOf(modelo.getId()), modelo.getModelo()));
//
//		return modelosValues;
//	}

	@GetMapping("/getModelosByMarca")
	public ResponseEntity<?> getModelosByMarca(@RequestParam("modelo.marca") Integer idMarca) throws Exception {
		try {
			return new ResponseEntity<Map<String, String>>(ToHashMap(marcaService.listarPorId(idMarca).getModelos()),
					HttpStatus.OK);

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

	private Map<String, String> ToHashMap(List<Modelo> modelos) {
		Map<String, String> modelosValues = new HashMap<>();
		modelosValues.put("0", "[Seleccione un Modelo]");

		if (modelos.size() != 0) {
			modelos.forEach(modelo -> modelosValues.put(String.valueOf(modelo.getId()), modelo.getModelo()));
		}

		return modelosValues;
	}
}