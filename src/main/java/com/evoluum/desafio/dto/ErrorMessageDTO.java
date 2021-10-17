package com.evoluum.desafio.dto;

public class ErrorMessageDTO extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public ErrorMessageDTO() {
	}

	public ErrorMessageDTO(String message) {
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
