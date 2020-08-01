package com.udemy.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "conductores")
public class Conductor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "dni", length = 20, nullable = false)
	private String dni;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha_nacimiento;

	@Column(name = "nombre_completo", length = 100, nullable = false)
	private String nombreCompleto;

	@Column(name = "telefono", length = 20, nullable = true)
	private String telefono;

	@Column(name = "correo_electronico", length = 100, nullable = false)
	private String correoElectronico;

	@Column(name = "estado", nullable = false)
	private boolean estado;

	public Conductor() {
	}

	public Conductor(String dni) {
		super();
		this.dni = dni;
	}

	public Conductor(String dni, LocalDate fecha_nacimiento, String nombreCompleto, String telefono,
			String correoElectronico, boolean estado) {
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

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public void setDni(String dni) {
		this.dni = dni;
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