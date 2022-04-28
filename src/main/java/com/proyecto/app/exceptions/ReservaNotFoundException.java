package com.proyecto.app.exceptions;

@SuppressWarnings("serial")
public class ReservaNotFoundException extends RuntimeException {

	public ReservaNotFoundException(Long id) {
		super("No se pudo encontrar la reserva por el id:" + id);
	}
	
	public ReservaNotFoundException(String id) {
		super("No se pudo encontrar la reserva por el id:" + id);
	}
}
 