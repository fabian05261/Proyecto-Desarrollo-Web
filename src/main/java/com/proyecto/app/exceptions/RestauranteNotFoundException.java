package com.proyecto.app.exceptions;

@SuppressWarnings("serial")
public class RestauranteNotFoundException extends RuntimeException {

	public RestauranteNotFoundException(Long id) {
		super("No se pudo encontrar el restaurante por el id:" + id);
	}
	
	public RestauranteNotFoundException(String id) {
		super("No se pudo encontrar el restaurante por el id:" + id);
	}
}