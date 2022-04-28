package com.proyecto.app.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.app.entidades.Cliente;
import com.proyecto.app.repositories.ClienteRepository;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Cliente crearCliente(Cliente cliente) {
		return repository.save(cliente);
	}
	
	@Override
	public Cliente actualizarCliente(Cliente cliente, Long id) {

		return repository.findById(id).map(provider -> {
			provider.setCodigo(cliente.getCodigo());
			provider.setNombre(cliente.getNombre());
			provider.setCorreo(cliente.getCorreo());
			provider.setNumero(cliente.getNumero());
			provider.setReservas(cliente.getReservas());
			provider.setRestaurantes(cliente.getRestaurantes());

			return repository.save(provider);
		}).orElseGet(() -> {
			throw null ;
		});
	}
	
	@Override
	public void eliminarCliente(Long id) {
		Optional<Cliente> cliente = repository.findById(id);

		if (cliente.isPresent()) {
			repository.delete(cliente.get());
			System.out.println("Cliente eliminado exitosamente...");
		} else {
			throw null;
		}
	}
	
	@Override
	public Cliente getClienteById(Long id) {
		return repository.getById(id);
	}
	
	@Override
	public Cliente getClienteByCorreo(String correo) {
		return repository.getByCorreo(correo);
	}
	
	@Override
	public List<Cliente> getClientesByFecha(Timestamp fecha){		
		return repository.findClientesByFecha(fecha);
	}
	
	@Override
	public List<Cliente> getClientesByRestaurante(Long restauranteID){	
		return repository.findClienteByRestaurante(restauranteID);
	}
	
	@Override
	public List<Cliente> getClientesByRango(Timestamp fecha1, Timestamp fecha2){	
		return repository.findClientesByRango(fecha1, fecha2);
	}
	
	@Override
	public Page<Cliente> getClientes(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
