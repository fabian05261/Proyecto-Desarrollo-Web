package com.proyecto.app.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.app.entidades.Reserva;

import com.proyecto.app.repositories.ReservaRepository;

@Service
public class ReservaService implements IReservaService {
	
	@Autowired
	private ReservaRepository repository;
	
	@Override
	public Reserva crearReserva(Reserva reserva) {
		return repository.save(reserva);
	}
	
	@Override
	public Reserva actualizarReserva(Reserva reserva, Long id) {

		return repository.findById(id).map(provider -> {
			provider.setCodigo(reserva.getCodigo());
			provider.setFecha(reserva.getFecha());
			provider.setCantidadClientes(reserva.getCantidadClientes());
			provider.setEstado(reserva.getEstado());
			provider.setCliente(reserva.getCliente());
			provider.setRestaurante(reserva.getRestaurante());

			return repository.save(provider);
		}).orElseGet(() -> {
			throw null ;
		});
	}
	
	@Override
	public void eliminarReserva(Long id) {
		Optional<Reserva> reserva = repository.findById(id);

		if (reserva.isPresent()) {
			repository.delete(reserva.get());
		} else {
			throw null;
		}
	}
	
	@Override
	public Reserva getReservaById(Long id) {
		return repository.getById(id);
	}
	
	@Override
	public List<Reserva> getReservasByCantidad(Long cantidad) {
		return repository.findByClientesEquals(cantidad);
	}
	
	@Override
	public List<Reserva> getReservasByEstadoTrue() {
		return repository.findByEstadoTrue();
	}
	
	@Override
	public List<Reserva> getReservasByEstadoFalse() {
		return repository.findByEstadoFalse();
	}
	
	@Override
	public List<Reserva> getReservasByFecha(Timestamp fecha){		
		return repository.findReservasByFecha(fecha);
	}
	
	@Override
	public List<Reserva> getReservasByRestaurante(Long restauranteID){	
		return repository.findReservasByRestaurante(restauranteID);
	}
	
	@Override
	public List<Reserva> getReservasByCliente(Long clienteID){	
		return repository.findReservasByCliente(clienteID);
	}
	
	@Override
	public List<Reserva> getReservasByRango(Timestamp fecha1, Timestamp fecha2){	
		return repository.findReservasByRango(fecha1, fecha2);
	}
	
	@Override
	public Page<Reserva> getReservas(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
}
