package com.udemy.model.values;

public enum EstadoViaje {

	SALIENDO(1), EN_CURSO(2), LLEGADA_DESTINO(3), REGRESANDO(4), RETORNADO(5);

	private Integer estado;

	private EstadoViaje(Integer estado) {
		this.estado = estado;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
}