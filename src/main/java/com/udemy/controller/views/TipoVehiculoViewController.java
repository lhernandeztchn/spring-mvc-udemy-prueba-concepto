package com.udemy.controller.views;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.controller.common.view.ControllerView;
import com.udemy.controller.common.view.LandingPages;
import com.udemy.model.TipoVehiculo;
import com.udemy.service.ITipoVehiculoService;

@Controller
@RequestMapping("/tipo_vehiculo")
public class TipoVehiculoViewController extends ControllerView {

	@Autowired
	ITipoVehiculoService service;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("listado", service.listar());
		return "tipo_vehiculo/lista";
	}

	@GetMapping(path = { "/form", "/form/{id}" })
	public String listarPorId(Model model, @PathVariable("id") Optional<Integer> id) {
		if (id.isPresent()) {
			model.addAttribute("titulo", "Modificar Tipo de Vehículo");
			model.addAttribute("tipoVehiculoForm", service.listarPorId(id.get()));
		} else {
			model.addAttribute("titulo", "Nuevo Tipo de Vehiculo");
			model.addAttribute("tipoVehiculoForm", new TipoVehiculo());
		}
		return "tipo_vehiculo/form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable("id") Integer id) {
		service.eliminar(id);
		return "redirect:/tipo_vehiculo/listar";
	}

	@PostMapping("/procesar")
	public String salvar(Model model, @Valid @ModelAttribute("tipoVehiculoForm") TipoVehiculo tipoVehiculo,
			BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				return "tipo_vehiculo/form";
			} else {
				if (service.listarPorId(tipoVehiculo.getId()) == null) {
					service.crear(tipoVehiculo);
					return Landing(model, "Crear Tipo de Vehículo", "El Tipo de Vehículo Fue Creada con Exito", "form",
							LandingPages.SUCCESS);
				} else {
					service.modificar(tipoVehiculo);
					return Landing(model, "Modificar Tipo de Vehículo",
							"La Información Tipo de Vehículo Fue Modificada con Exito", "listar", LandingPages.SUCCESS);
				}
			}
		} catch (Exception e) {
			return Landing(model, "Error Guardando el Tipo de Vehículo", e.getMessage(), "listar", LandingPages.ERROR);
		}
	}
}