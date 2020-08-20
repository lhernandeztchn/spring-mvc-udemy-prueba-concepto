package com.udemy.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "viajes")
public class Viajes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "fecha_retorno", nullable = false)
	private LocalDateTime fechaSalida;

	@Column(name = "motivo", length = 100, nullable = false)
	private String motivo;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "conductor_dni", referencedColumnName = "conductor_dni"),
			@JoinColumn(name = "vehiculo_id", referencedColumnName = "vehiculo_id") })
	private AsignacionConductorVehiculo conductorVehiculo;

	@Column(name = "estado", nullable = false)
	private boolean estado;

	@Column(name = "estado_viaje", length = 1)
	private Integer estadoViaje;

	@Column(name = "fecha_retorno", nullable = true, insertable = false, updatable = false)
	private LocalDateTime fechaRetorno;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public AsignacionConductorVehiculo getConductorVehiculo() {
		return conductorVehiculo;
	}

	public void setConductorVehiculo(AsignacionConductorVehiculo conductorVehiculo) {
		this.conductorVehiculo = conductorVehiculo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Integer getEstadoViaje() {
		return estadoViaje;
	}

	public void setEstadoViaje(Integer estadoViaje) {
		this.estadoViaje = estadoViaje;
	}

	public LocalDateTime getFechaRetorno() {
		return fechaRetorno;
	}

	public void setFechaRetorno(LocalDateTime fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}
}