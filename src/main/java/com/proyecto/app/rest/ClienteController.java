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

import com.proyecto.app.dtos.ClienteDTO;
import com.proyecto.app.entidades.Cliente;
import com.proyecto.app.services.IClienteService;


@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("/crear")
	public ClienteDTO crearCliente(@RequestBody Cliente cliente) {
		Cliente c = clienteService.crearCliente(cliente);
		ClienteDTO clienteDTO = new ClienteDTO(c);
		System.out.println("Cliente creado exitosamente...");
		return clienteDTO;
	}
	
	@PutMapping("actualizar/{id}")
	public ClienteDTO actualizarCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente c = clienteService.actualizarCliente(cliente, id);
		ClienteDTO clienteDTO = new ClienteDTO(c);
		System.out.println("Cliente actualizado exitosamente...");
		return clienteDTO;
	}
	
	@DeleteMapping("eliminar/{id}")
	public void eliminarCliente(@PathVariable Long id) {
		clienteService.eliminarCliente(id);
		System.out.println("Cliente eliminado exitosamente...");
	}
	
	@GetMapping("consultar/{id}")
	public ClienteDTO getClienteById(@PathVariable Long id) {
		Cliente c = clienteService.getClienteById(id);
		ClienteDTO cliente = new ClienteDTO(c);
		return cliente;
	}
	
	@GetMapping("correo/{correo}")
	public ClienteDTO getClienteByCorreo(@PathVariable("correo") String correo) {
		Cliente c = clienteService.getClienteByCorreo(correo);
		ClienteDTO cliente = new ClienteDTO(c);
		return cliente;
	}
	
	@GetMapping("reservas/{fecha}")
	public List<ClienteDTO> getClientesByReserva(@PathVariable("fecha") String fecha) {
		Timestamp f = Timestamp.valueOf(fecha);
		List<Cliente> c = clienteService.getClientesByFecha(f);
		List<ClienteDTO> clientes = convertClientes(c);
		return clientes;
	}
	
	@GetMapping("restaurantes/{id}")
	public List<ClienteDTO> getClientesByRestaurante(@PathVariable Long id) {
		List<Cliente> c = clienteService.getClientesByRestaurante(id);
		List<ClienteDTO> clientes = convertClientes(c);
		return clientes;
	}
	
	@GetMapping("reservas/{fecha1}/{fecha2}")
	public List<ClienteDTO> getClientesByReserva(@PathVariable("fecha1") String fecha1, @PathVariable("fecha2") String fecha2) {
		Timestamp f1 = Timestamp.valueOf(fecha1);
		Timestamp f2 = Timestamp.valueOf(fecha2);
		List<Cliente> c =  clienteService.getClientesByRango(f1,f2);
		List<ClienteDTO> clientes = convertClientes(c);
		return clientes;
	}
	
	@GetMapping("listar/{page}/{size}")
	public Page<ClienteDTO> getClientes(@PathVariable("page") int pagina, @PathVariable("size") int size) {
		Pageable pageable = (Pageable) new SolrPageRequest(pagina, size, Sort.by(Direction.ASC, "id"));
		Page<Cliente> clientes = clienteService.getClientes(pageable);
		
		List<ClienteDTO> result = convertDTOs(clientes);
		System.out.println("Clientes listados exitosamente...");
		return new PageImpl<>(result, pageable, clientes.getTotalElements());
	}

	private List<ClienteDTO> convertDTOs(Page<Cliente> clientes) {
		List<ClienteDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Cliente cliente : clientes) {
			result.add(mapper.map(cliente, ClienteDTO.class));
		}
		return result;
	}
	
	private List<ClienteDTO> convertClientes(List<Cliente> clientes) {
		List<ClienteDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Cliente cliente : clientes) {
			result.add(mapper.map(cliente, ClienteDTO.class));
		}
		return result;
	}
}
