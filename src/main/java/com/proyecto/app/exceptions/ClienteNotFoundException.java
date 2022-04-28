package com.proyecto.app.exceptions;

@SuppressWarnings("serial")
public class ClienteNotFoundException extends RuntimeException {

	public ClienteNotFoundException(Long id) {
		super("No se pudo encontrar el cliente por el id:" + id);
	}
	
	public ClienteNotFoundException(String id) {
		super("No se pudo encontrar el cliente por el id:" + id);
	}
}
 