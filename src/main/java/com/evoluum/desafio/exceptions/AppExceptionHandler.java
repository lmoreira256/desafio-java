package com.evoluum.desafio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.evoluum.desafio.dto.ErrorMessageDTO;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ErrorMessageDTO.class)
	public ResponseEntity<Object> handleAnyException(ErrorMessageDTO e) {
		ErrorMessageSchema errorMessageSchema = new ErrorMessageSchema(e.getMessage());

		return new ResponseEntity<Object>(errorMessageSchema, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
