package com.udemy.controller.forms.conductor;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("deprecation")
public class ConductorForm {

	@NotEmpty
	@Size(max = 13)
	private String dni;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private Date fecha_nacimiento;

	@NotEmpty
	@Size(min = 2, max = 100)
	private String nombreCompleto;

	@NotEmpty
	@Size(min = 2, max = 20)
	private String telefono;

	@NotEmpty
	@Size(min = 2, max = 100)
	private String correoElectronico;

	private boolean estado;

	public ConductorForm() {
	}

	public ConductorForm(@NotEmpty @Size(max = 13) String dni, @NotEmpty @Past Date fecha_nacimiento,
			@NotEmpty @Size(min = 2, max = 100) String nombreCompleto,
			@NotEmpty @Size(min = 2, max = 20) String telefono,
			@NotEmpty @Size(min = 2, max = 100) String correoElectronico, boolean estado) {
		super();
		this.dni = dni;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.estado = estado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}