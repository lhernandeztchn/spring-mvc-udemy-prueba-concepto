package com.udemy.controller.map;

import java.time.ZoneId;

import com.udemy.controller.forms.conductor.ConductorForm;
import com.udemy.model.Conductor;

public class ConductorMap {

	public static Conductor toConductor(ConductorForm form) {

		return new Conductor(form.getDni(),
				form.getFecha_nacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				form.getNombreCompleto(), form.getTelefono(), form.getCorreoElectronico(), form.isEstado());
	}

	public static ConductorForm toConductorForm(Conductor ob) {

		return new ConductorForm(ob.getDni(),
				java.util.Date.from(ob.getFecha_nacimiento().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
				ob.getNombreCompleto(), ob.getTelefono(), ob.getCorreoElectronico(), ob.isEstado());
	}
}