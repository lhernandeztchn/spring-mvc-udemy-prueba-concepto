package com.udemy.controller.common.view;

import org.springframework.ui.Model;

public class ControllerView {

	public String Landing(Model model, String titulo, String mensaje, String link, LandingPages landing) {
		model.addAttribute("titulo", titulo);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("link", link);

		if (landing.equals(LandingPages.ERROR))
			return "landing/error";

		return "landing/success";

	}

}
