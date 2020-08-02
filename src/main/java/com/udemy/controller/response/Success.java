package com.udemy.controller.response;

import java.io.Serializable;

public class Success<ID> implements Serializable {

	private static final long serialVersionUID = 1L;

	private ID id;
	private Integer codigo;
	private String mensaje;
	
	public Success() {
	}
	
	public Success(ID id, Integer codigo, String mensaje) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}