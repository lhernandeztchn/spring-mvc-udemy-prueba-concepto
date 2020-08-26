	package com.udemy.controller.views;

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
@RequestMapping("/marca/modelo")
public class ModeloViewController extends ControllerView {

	@Autowired
	IMarcaService service;

	@GetMapping(path = "/form/{idMarca}")
	public String listarModelPorIdMarca(Model model, @PathVariable("idMarca") Integer id) {
		model.addAttribute("titulo", "Modelos Disponibles / "+service.listarPorId(id).getMarca());
		return "marca/modelo-form";
	}
	
	@PostMapping(path =  "/form/{idMarca}" )
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