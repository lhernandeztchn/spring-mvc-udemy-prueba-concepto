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
import com.udemy.model.Marca;
import com.udemy.service.IMarcaService;

@Controller
@RequestMapping("/marca")
public class MarcaViewController extends ControllerView {

	@Autowired
	IMarcaService service;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("listado", service.listar());
		return "marca/lista";
	}

	@GetMapping(path = { "/form", "/form/{id}" })
	public String listarPorId(Model model, @PathVariable("id") Optional<Integer> id) {
		if (id.isPresent()) {
			model.addAttribute("titulo", "Modificar Marca");
			model.addAttribute("marcaForm", service.listarPorId(id.get()));
		} else {
			model.addAttribute("titulo", "Nueva Marca");
			model.addAttribute("marcaForm", new Marca());
		}
		return "marca/form";
	}

	

	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable("id") Integer id) {
		service.eliminar(id);
		return "redirect:/marca/lista";
	}

	@PostMapping("/procesarMarca")
	public String salvarMarca(Model model, @Valid @ModelAttribute("marcaForm") Marca marca,
			BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				return "marca/form";
			} else {
				if (service.listarPorId(marca.getId()) == null) {
					service.crear(marca);
					return Landing(model, "Crear Marca", "La Marca" + marca.getMarca() + " Fue Creada con Exito",
							"form", LandingPages.SUCCESS);
				} else {
					service.modificar(marca);
					return Landing(model, "Modificar Marca",
							"La Información de la Marca Fue Modificada con Exito", "listar",
							LandingPages.SUCCESS);
				}
			}
		} catch (Exception e) {
			return Landing(model, "Error Guardando la Marca", e.getMessage(), "listar", LandingPages.ERROR);
		}
	}
}