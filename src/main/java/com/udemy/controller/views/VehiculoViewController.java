package com.udemy.controller.views;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.controller.common.view.ControllerView;
import com.udemy.model.Vehiculo;
import com.udemy.service.IMarcaService;
import com.udemy.service.IVehiculoService;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoViewController extends ControllerView {

	@Autowired
	IVehiculoService service;

	@Autowired
	IMarcaService marcaService;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("listado", service.listar());
		return "vehiculos/lista";
	}

	@GetMapping(path = { "/form", "/form/{id}" })
	public String listarPorId(Model model, @PathVariable("id") Optional<Integer> id) {
		model.addAttribute("marcas", marcaService.listar());

		if (id.isPresent()) {			
			model.addAttribute("titulo", "Modificar Vehículo");
			model.addAttribute("vehiculoForm", service.listarPorId(id.get()));
		} else {
			model.addAttribute("titulo", "Nuevo Vehículo");
			model.addAttribute("vehiculoForm", new Vehiculo());
		}
		return "vehiculos/form";
	}
}