package com.udemy.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AsignacionConductorVehiculoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "conductor_dni")
	private String conductorDni;

	@Column(name = "vehiculo_id")
	private Integer vehiculoId;

	public AsignacionConductorVehiculoPK() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(getConductorDni(), getVehiculoId());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof AsignacionConductorVehiculoPK))
			return false;
		AsignacionConductorVehiculoPK that = (AsignacionConductorVehiculoPK) o;
		return Objects.equals(getConductorDni(), that.getConductorDni())
				&& Objects.equals(getVehiculoId(), that.getVehiculoId());
	}

	public String getConductorDni() {
		return conductorDni;
	}

	public void setConductorDni(String conductorDni) {
		this.conductorDni = conductorDni;
	}

	public Integer getVehiculoId() {
		return vehiculoId;
	}

	public void setVehiculoId(Integer vehiculoId) {
		this.vehiculoId = vehiculoId;
	}

}