package com.proyecto.app.services;


import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.app.entidades.Restaurante;
import com.proyecto.app.repositories.RestauranteRepository;

@Service
public class RestauranteService implements IRestauranteService{
	
	@Autowired
	private RestauranteRepository repository;
	
	@Override
	public Restaurante crearRestaurante(Restaurante restaurante) {
		return repository.save(restaurante);
	}
	
	@Override
	public Restaurante actualizarRestaurante(Restaurante restaurante, Long id) {

		return repository.findById(id).map(provider -> {
			provider.setCodigo(restaurante.getCodigo());
			provider.setNombre(restaurante.getNombre());
			provider.setDescripcion(restaurante.getDescripcion());
			provider.setDireccion(restaurante.getDireccion());
			provider.setNumero(restaurante.getNumero());
			provider.setReservas(restaurante.getReservas());
			provider.setClientes(restaurante.getClientes());

			return repository.save(provider);
		}).orElseGet(() -> {
			throw null ;
		});
	}
	
	@Override
	public void eliminarRestaurante(Long id) {
		Optional<Restaurante> restaurante = repository.findById(id);

		if (restaurante.isPresent()) {
			repository.delete(restaurante.get());
			
		} else {
			throw null;
		}
	}
	
	@Override
	public Restaurante getRestauranteById(Long id) {
		return repository.getById(id);
	}
	
	@Override
	public List<Restaurante> getRestaurantesByDescripcion(String descripcion) {
		return repository.findByDescripcionContaining(descripcion);
	}
	
	@Override
	public List<Restaurante> getRestaurantesByReserva(Timestamp fecha){
		return repository.findRestauranteByReserva(fecha);
	}
	
	@Override
	public Page<Restaurante> getRestaurantes(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
