package com.evoluum.desafio.exceptions;

public class ErrorMessageSchema {

	private String message;

	public ErrorMessageSchema() {
	}

	public ErrorMessageSchema(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
