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
import com.udemy.controller.forms.conductor.ConductorForm;
import com.udemy.controller.map.ConductorMap;
import com.udemy.service.IConductorService;

@Controller
@RequestMapping("/conductor")
public class ConductorViewController extends ControllerView {

	@Autowired
	IConductorService service;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("conductores", service.listar());
		return "conductor/listar";
	}

	@GetMapping(path = { "/form", "/form/{id}" })
	public String listarPorId(Model model, @PathVariable("id") Optional<String> id) {
		if (id.isPresent()) {
			model.addAttribute("titulo", "Modificar Conductor");
			model.addAttribute("conductor", ConductorMap.toConductorForm(service.listarPorId(id.get())));
		} else {
			model.addAttribute("titulo", "Nuevo Conductor");
			model.addAttribute("conductor", new ConductorForm());
		}
		return "conductor/form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable("id") String id) {
		service.eliminar(id);
		return "redirect:/conductor/listar";
	}

	@PostMapping("/procesar")
	public String salvar(Model model, @Valid @ModelAttribute("conductor") ConductorForm con,
			BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				return "conductor/form";
			} else {
				if (service.listarPorId(con.getDni()) == null) {
					service.crear(ConductorMap.toConductor(con));
					return Landing(model, "Crear Conductor(a)",
							"El Conductor(a) " + con.getNombreCompleto() + " Fue Creado creado con Exito", "form",
							LandingPages.SUCCESS);
				} else {
					service.modificar(ConductorMap.toConductor(con));
					return Landing(model, "Modificar Conductor(a)",
							"La Información del " + con.getNombreCompleto() + " Fue Modificada con Exito", "listar",
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