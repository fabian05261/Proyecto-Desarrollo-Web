package com.proyecto.app.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.solr.core.query.SolrPageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyecto.app.dtos.RestauranteDTO;
import com.proyecto.app.entidades.Restaurante;
import com.proyecto.app.services.IRestauranteService;

@RestController
@RequestMapping("restaurantes")
public class RestauranteController {

	@Autowired
	private IRestauranteService restauranteService;
	
	
	@PostMapping("/crear")
	public RestauranteDTO crearRestaurante(@RequestBody Restaurante restaurante) {
		Restaurante r = restauranteService.crearRestaurante(restaurante);
		RestauranteDTO restauranteDTO = new RestauranteDTO(r);
		System.out.println("Restaurante creado exitosamente...");
		return restauranteDTO;
	}
	
	@PutMapping("actualizar/{id}")
	public RestauranteDTO actualizarRestaurante(@RequestBody Restaurante restaurante, @PathVariable Long id) {
		Restaurante r = restauranteService.actualizarRestaurante(restaurante, id);
		RestauranteDTO restauranteDTO = new RestauranteDTO(r);
		System.out.println("Restaurante actualizado exitosamente...");
		return restauranteDTO;
		
	}
	
	@DeleteMapping("eliminar/{id}")
	public void eliminarRestaurante(@PathVariable Long id) {
		restauranteService.eliminarRestaurante(id);
		System.out.println("Restaurante eliminado exitosamente...");
	}
	
	@GetMapping("consultar/{id}")
	public RestauranteDTO getRestauranteById(@PathVariable Long id) {
		Restaurante r = restauranteService.getRestauranteById(id);
		RestauranteDTO restaurante = new RestauranteDTO(r);
		return restaurante;
	}
	
	@GetMapping("descripcion/{descripcion}")
	public List<RestauranteDTO> getRestaurantesByDescripcion(@PathVariable("descripcion") String descripcion) {
		List<Restaurante> r = restauranteService.getRestaurantesByDescripcion(descripcion);
		List<RestauranteDTO> restaurantes = convertRestaurantes(r);
		return restaurantes;
	}
	
	@GetMapping("reservas/{fecha}")
	public List<RestauranteDTO> getRestaurantesByReserva(@PathVariable("fecha") String fecha) {
		Timestamp f = Timestamp.valueOf(fecha);
		List<Restaurante> r = restauranteService.getRestaurantesByReserva(f);
		List<RestauranteDTO> restaurantes = convertRestaurantes(r);
		return restaurantes;
	}
	
	@GetMapping("listar/{page}/{size}")
	public Page<RestauranteDTO> getRestaurantes(@PathVariable("page") int pagina, @PathVariable("size") int size) {
		Pageable pageable = (Pageable) new SolrPageRequest(pagina, size, Sort.by(Direction.ASC, "id"));
		Page<Restaurante> restaurantes = restauranteService.getRestaurantes(pageable);
		
		List<RestauranteDTO> result = convertDTOs(restaurantes);
		System.out.println("Restaurantes listados exitosamente...");
		return new PageImpl<>(result, pageable, restaurantes.getTotalElements());
	}

	private List<RestauranteDTO> convertDTOs(Page<Restaurante> restaurantes) {
		List<RestauranteDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Restaurante restaurante : restaurantes) {
			result.add(mapper.map(restaurante, RestauranteDTO.class));
		}
		return result;
	}
	
	private List<RestauranteDTO> convertRestaurantes(List<Restaurante> restaurantes) {
		List<RestauranteDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Restaurante restaurante : restaurantes) {
			result.add(mapper.map(restaurante, RestauranteDTO.class));
		}
		return result;
	}
	
}
