package com.udemy.model.values;

public enum Transmision {

	MANUAL("M"), 
	AUTOMATICA("AU"), 
	TRIPTRONIC("TRC");

	private String transmision;

	private Transmision(String transmision) {
		this.transmision = transmision;
	}

	public String getTransmision() {
		return transmision;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}
}