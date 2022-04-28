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

import com.proyecto.app.dtos.ReservaDTO;
import com.proyecto.app.entidades.Reserva;
import com.proyecto.app.services.IReservaService;

@RestController
@RequestMapping("reservas")
public class ReservaController {
	
	@Autowired
	private IReservaService reservaService;
	
	@PostMapping("/crear")
	public ReservaDTO crearReserva(@RequestBody Reserva reserva) {
		
		Reserva r =  reservaService.crearReserva(reserva);
		ReservaDTO reservaDTO = new ReservaDTO(r);
		System.out.println("Reserva creada exitosamente...");
		return reservaDTO;
	}
	
	@PutMapping("/actualizar/{id}")
	public ReservaDTO actualizarReserva(@RequestBody Reserva reserva,@PathVariable long id)
	{
		Reserva r = reservaService.actualizarReserva(reserva, id);
		ReservaDTO reservaDTO = new ReservaDTO(r);
		System.out.println("Reserva actualizada exitosamente...");
		return reservaDTO;
	}
	
	@DeleteMapping("eliminar/{id}")
	public void eliminarReserva(@PathVariable Long id) {
		reservaService.eliminarReserva(id);
		System.out.println("Reserva eliminada exitosamente...");
	}
	
	@GetMapping("consultar/{id}")
	public ReservaDTO getReservaById(@PathVariable Long id) {
		Reserva r = reservaService.getReservaById(id);
		ReservaDTO reserva = new ReservaDTO(r);
		return reserva;
	}
	
	@GetMapping("cantidad/{cantidad}")
	public List<ReservaDTO> getReservasByCantidad(@PathVariable Long cantidad) {
		List<Reserva> r = reservaService.getReservasByCantidad(cantidad);
		List<ReservaDTO> reservas = convertReservas(r);
		return reservas;

	}
	
	@GetMapping("estado/{estado}")
	public List<ReservaDTO> getReservasByEstado(@PathVariable boolean estado) {
		
		if(estado) {
			List<Reserva> r =  reservaService.getReservasByEstadoTrue();
			List<ReservaDTO> reservas = convertReservas(r);
			return reservas;
		}
		else {
			List<Reserva> r =  reservaService.getReservasByEstadoFalse();
			List<ReservaDTO> reservas = convertReservas(r);
			return reservas;
		}
		
	}
	
	@GetMapping("fecha/{fecha}")
	public List<ReservaDTO> getReservasByReserva(@PathVariable("fecha") String fecha) {
		Timestamp f = Timestamp.valueOf(fecha);
		List<Reserva> r = reservaService.getReservasByFecha(f);
		List<ReservaDTO> reservas = convertReservas(r);
		return reservas;
	}
	
	@GetMapping("restaurante/{id}")
	public List<ReservaDTO> getReservasByRestaurante(@PathVariable Long id) {
		
		List<Reserva> r = reservaService.getReservasByRestaurante(id);
		List<ReservaDTO> reservas = convertReservas(r);
		return reservas;
	
	}
	
	@GetMapping("cliente/{id}")
	public List<ReservaDTO> getReservasByCliente(@PathVariable Long id) {
		List<Reserva> r =  reservaService.getReservasByCliente(id);
		List<ReservaDTO> reservas = convertReservas(r);
		return reservas;
	}
	
	@GetMapping("rango/{fecha1}/{fecha2}")
	public List<ReservaDTO> getReservasByRango(@PathVariable("fecha1") String fecha1, @PathVariable("fecha2") String fecha2) {
		Timestamp f1 = Timestamp.valueOf(fecha1);
		Timestamp f2 = Timestamp.valueOf(fecha2);
		List<Reserva> r =  reservaService.getReservasByRango(f1, f2);
		List<ReservaDTO> reservas = convertReservas(r);
		return reservas;
		
	}
		
	@GetMapping("listar/{page}/{size}")
	public Page<ReservaDTO> getReservas(@PathVariable("page") int pagina, @PathVariable("size") int size) {
		Pageable pageable = (Pageable) new SolrPageRequest(pagina, size, Sort.by(Direction.ASC, "id"));
		Page<Reserva> reservas = reservaService.getReservas(pageable);
		
		List<ReservaDTO> result = convertDTOs(reservas);
		System.out.println("Reservas listadas exitosamente...");
		return new PageImpl<>(result, pageable, reservas.getTotalElements());
	}

	private List<ReservaDTO> convertDTOs(Page<Reserva> reservas) {
		List<ReservaDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Reserva reserva : reservas) {
			result.add(mapper.map(reserva, ReservaDTO.class));
		}
		return result;
	}
	
	private List<ReservaDTO> convertReservas(List<Reserva> reservas) {
		List<ReservaDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Reserva reserva : reservas) {
			result.add(mapper.map(reserva, ReservaDTO.class));
		}
		return result;
	}
}