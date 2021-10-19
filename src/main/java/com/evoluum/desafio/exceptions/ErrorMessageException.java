package com.evoluum.desafio.exceptions;

public class ErrorMessageException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public ErrorMessageException() {
	}

	public ErrorMessageException(String message) {
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
