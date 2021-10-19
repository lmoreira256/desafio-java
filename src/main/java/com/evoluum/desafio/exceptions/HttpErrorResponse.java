package com.evoluum.desafio.exceptions;

public class HttpErrorResponse {

	private String message;

	public HttpErrorResponse() {
	}

	public HttpErrorResponse(String message) {
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
