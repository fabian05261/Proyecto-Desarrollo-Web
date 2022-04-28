package com.proyecto.app.services;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import com.proyecto.app.entidades.Restaurante;

public interface IRestauranteService {
	
	Restaurante crearRestaurante(Restaurante restaurante);
	
	Restaurante actualizarRestaurante (Restaurante restaurante, Long id);
	
	void eliminarRestaurante(Long id);
	
	Restaurante getRestauranteById(Long id);
	
	List<Restaurante> getRestaurantesByDescripcion(String descripcion);
	
	List<Restaurante> getRestaurantesByReserva(Timestamp fecha);
	
	Page<Restaurante> getRestaurantes(Pageable pageable);
	
	
}
