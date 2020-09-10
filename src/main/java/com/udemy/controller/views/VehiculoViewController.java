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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.udemy.controller.common.view.ControllerView;
import com.udemy.controller.common.view.LandingPages;
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

	@PostMapping("/procesar")
	public String salvar(@RequestParam("file") MultipartFile file, Model model,
			@Valid @ModelAttribute("vehiculo") Vehiculo vehiculo, BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				return "conductor/form";
			} else {
				if (service.listarPorId(vehiculo.getId()) == null) {
					/// service.crear(vehiculo);
					return Landing(model, "Crear Conductor(a)",
							"El Vehículo " + vehiculo.getModelo() + " Fue Creado creado con Exito", "form",
							LandingPages.SUCCESS);
				} else {
					// service.modificar(vehiculo);
					return Landing(model, "Modificar Conductor(a)",
							"La Información del " + vehiculo.getModelo() + " Fue Modificada con Exito", "listar",
							LandingPages.SUCCESS);
				}
			}
		} catch (Exception e) {
			return Landing(model, "Error Guardando Conductor(a)",
					"Hubo un error al momento de guardar un Conductor(a) en: " + e.getMessage(), "listar",
					LandingPages.ERROR);
		}
	}
}