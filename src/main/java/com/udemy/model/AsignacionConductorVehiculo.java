package com.udemy.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "public", name = "conductores_vehiculos")
public class AsignacionConductorVehiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AsignacionConductorVehiculoPK id;

	@Column(name = "estado", nullable = false)
	private boolean estado;

	@Column(name = "fecha_asignacion", nullable = false)
	private LocalDateTime fechaAsignacion;

	@Column(name = "fecha_finalizacion_asignacion", nullable = true)
	private LocalDateTime fechaFinalizacionAsignacion;

	@JsonIgnore
	@OneToMany(mappedBy = "conductorVehiculo", fetch = FetchType.LAZY)
	private List<Viajes> viajes;

	public AsignacionConductorVehiculo() {
	}

	public AsignacionConductorVehiculoPK getId() {
		return id;
	}

	public void setId(AsignacionConductorVehiculoPK id) {
		this.id = id;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public LocalDateTime getFechaFinalizacionAsignacion() {
		return fechaFinalizacionAsignacion;
	}

	public void setFechaFinalizacionAsignacion(LocalDateTime fechaFinalizacionAsignacion) {
		this.fechaFinalizacionAsignacion = fechaFinalizacionAsignacion;
	}

	public List<Viajes> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viajes> viajes) {
		this.viajes = viajes;
	}

}