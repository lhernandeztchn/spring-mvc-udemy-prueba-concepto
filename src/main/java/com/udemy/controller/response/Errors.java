package com.udemy.controller.response;

import java.io.Serializable;

public class Errors implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;
	private String innerException;
	private String details;
	
	public Errors() {
	}

	public Errors(Integer code, String innerException, String details) {
		super();
		this.code = code;
		this.innerException = innerException;
		this.details = details;
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getInnerException() {
		return innerException;
	}

	public void setInnerException(String innerException) {
		this.innerException = innerException;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}