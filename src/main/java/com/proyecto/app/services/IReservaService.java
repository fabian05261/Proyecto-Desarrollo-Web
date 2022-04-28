package com.proyecto.app.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.app.entidades.Reserva;


public interface IReservaService {
	
	Reserva crearReserva(Reserva reserva);

	Reserva actualizarReserva(Reserva reserva, Long id);
	
	void eliminarReserva(Long id);
	
	Reserva getReservaById(Long id);
	
	List<Reserva> getReservasByCantidad(Long cantidad);
	
	List<Reserva> getReservasByEstadoTrue();
	
	List<Reserva> getReservasByEstadoFalse();
	
	List<Reserva> getReservasByFecha(Timestamp fecha);
	
	List<Reserva> getReservasByRestaurante(Long restauranteID);
	
	List<Reserva> getReservasByCliente(Long clienteID);
	
	List<Reserva> getReservasByRango(Timestamp fecha1, Timestamp fecha2);
	
	Page<Reserva> getReservas(Pageable pageable);
}
