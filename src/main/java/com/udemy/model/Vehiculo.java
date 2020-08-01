package com.udemy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "vehiculos")
public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "modelo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_vehiculo_id_modelo"))
	private Modelo modelo;

	@ManyToOne
	@JoinColumn(name = "tipo_vehiculo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_vehiculo_id_tipo_vehiculo"))
	private TipoVehiculo tipoVehiculo;

	@Column(name = "placa", length = 10, nullable = false)
	private String placa;

	@Column(name = "vin", length = 50, nullable = false)
	private String VIN;

	@Column(name = "transmision", length = 3, nullable = false)
	private String transmision;

	@Column(name = "estado", nullable = false)
	private boolean estado;

	public Vehiculo() {
	}

	public Vehiculo(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public String getTransmision() {
		return transmision;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}
}