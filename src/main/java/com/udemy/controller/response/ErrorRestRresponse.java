package com.udemy.controller.response;

import java.io.Serializable;

public class ErrorRestRresponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;
	private String error;
	
	public ErrorRestRresponse() {
	}

	public ErrorRestRresponse(int code, String error) {
		super();
		this.code = code;
		this.error = error;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}