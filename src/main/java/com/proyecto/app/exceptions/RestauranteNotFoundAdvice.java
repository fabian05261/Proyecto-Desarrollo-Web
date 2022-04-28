package com.proyecto.app.exceptions;

import java.security.GeneralSecurityException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class RestauranteNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(RestauranteNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String restauranteNotFoundHandler(RestauranteNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(GeneralSecurityException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String restauranteNotFoundHandler(GeneralSecurityException ex) {
		return "Error al buscar restaurante";
	}
	
}