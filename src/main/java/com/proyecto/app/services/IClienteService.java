package com.proyecto.app.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.app.entidades.Cliente;


public interface IClienteService {
	
	Cliente crearCliente(Cliente cliente);

	Cliente actualizarCliente (Cliente cliente, Long id);
	
	void eliminarCliente(Long id);
	
	Cliente getClienteById(Long id);
	
	Cliente getClienteByCorreo(String correo);
		
	List<Cliente> getClientesByFecha(Timestamp fecha);
	
	List<Cliente> getClientesByRestaurante(Long restauranteID);
	
	List<Cliente> getClientesByRango(Timestamp fecha1, Timestamp fecha2);
	
	Page<Cliente> getClientes(Pageable pageable);
		
}
