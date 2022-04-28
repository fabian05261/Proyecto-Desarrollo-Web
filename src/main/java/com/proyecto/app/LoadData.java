package com.proyecto.app;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyecto.app.entidades.Cliente;
import com.proyecto.app.entidades.Reserva;
import com.proyecto.app.entidades.Restaurante;
import com.proyecto.app.repositories.ClienteRepository;
import com.proyecto.app.repositories.ReservaRepository;
import com.proyecto.app.repositories.RestauranteRepository;

@Configuration 
class LoadData {
	
	@Bean
	CommandLineRunner llenarBD (RestauranteRepository  restauranteRepository, ReservaRepository reservaRepository, ClienteRepository clienteRepository) {
		return args ->{
			System.out.println("Llenando la base de datos...");
			
//RESTAURANTES	
			Restaurante restaurante1 = new Restaurante();
			restaurante1.setId(1L);
			restaurante1.setCodigo(10L);
			restaurante1.setNombre("Little Ceasars");
			restaurante1.setDescripcion("La mejor pizza que puedes encontrar");
			restaurante1.setDireccion("Calle 135 #54-10");
			restaurante1.setNumero(3227658493L);
			restauranteRepository.save(restaurante1);
					
			Restaurante restaurante2 = new Restaurante();
			restaurante2.setId(2L);
			restaurante2.setCodigo(20L);
			restaurante2.setNombre("El Corral");
			restaurante2.setDescripcion("La mejor hamburguesa de la cidudad");
			restaurante2.setDireccion("Calle 69 #5-22");
			restaurante2.setNumero(3106657365L);
			restauranteRepository.save(restaurante2);
			
			Restaurante restaurante3 = new Restaurante();
			restaurante3.setId(3L);
			restaurante3.setCodigo(30L);
			restaurante3.setNombre("McDonald's");
			restaurante3.setDescripcion("Los mejores spicy nuggets");
			restaurante3.setDireccion("Calle 97 #24-12");
			restaurante3.setNumero(3103920192L);
			restauranteRepository.save(restaurante3);
			
			Restaurante restaurante4 = new Restaurante();
			restaurante4.setId(4L);
			restaurante4.setCodigo(40L);
			restaurante4.setNombre("Presto");
			restaurante4.setDescripcion("Las mejores papas");
			restaurante4.setDireccion("Carrera 9 #42-14");
			restaurante4.setNumero(3950920592L);
			restauranteRepository.save(restaurante4);
			
//CLIENTES			
			Cliente cliente1 = new Cliente();
			cliente1.setId(1L);
			cliente1.setNombre("Carlos Loreto");
			cliente1.setCodigo(100L);
			cliente1.setCorreo("carlos@javeriana.edu.co");
			cliente1.setNumero("3188325867");
			clienteRepository.save(cliente1);
			
			Cliente cliente2 = new Cliente();
			cliente2.setId(2L);
			cliente2.setNombre("Fabian Zapata");
			cliente2.setCodigo(200L);
			cliente2.setCorreo("fabian@javeriana.edu.co");
			cliente2.setNumero("3186453854");
			clienteRepository.save(cliente2);
			
			Cliente cliente3 = new Cliente();
			cliente3.setId(3L);
			cliente3.setNombre("Sofia Sepulveda");
			cliente3.setCodigo(300L);
			cliente3.setCorreo("Sofia@javeriana.edu.co");
			cliente3.setNumero("3220910291");
			clienteRepository.save(cliente3);
			
			Cliente cliente4 = new Cliente();
			cliente4.setId(4L);
			cliente4.setNombre("Andrea Valderrama");
			cliente4.setCodigo(400L);
			cliente4.setCorreo("Andrea@javeriana.edu.co");
			cliente4.setNumero("3120310191");
			clienteRepository.save(cliente4);
			
			Cliente cliente5 = new Cliente();
			cliente5.setId(5L);
			cliente5.setNombre("Julian Mejia");
			cliente5.setCodigo(500L);
			cliente5.setCorreo("Julian@javeriana.edu.co");
			cliente5.setNumero("3134310199");
			clienteRepository.save(cliente5);
			
//RESERVAS					
			Reserva reserva1 = new Reserva(1L,1000L,Timestamp.valueOf("2022-09-23 10:00:00"),3,true);
			reserva1.setCliente(cliente1);
			reserva1.setRestaurante(restaurante1);
			reservaRepository.save(reserva1);
			
			Reserva reserva2 = new Reserva(2L,2000L,Timestamp.valueOf("2022-05-26 22:00:00"),6,true);
			reserva2.setCliente(cliente2);
			reserva2.setRestaurante(restaurante1);
			reservaRepository.save(reserva2);
			
			Reserva reserva3 = new Reserva(3L,3000L,Timestamp.valueOf("2022-06-12 13:00:00"),10,false);
			reserva3.setCliente(cliente4);
			reserva3.setRestaurante(restaurante2);
			reservaRepository.save(reserva3);
			
			Reserva reserva4 = new Reserva(4L,4000L,Timestamp.valueOf("2022-04-29 09:00:00"),8,true);
			reserva4.setCliente(cliente3);
			reserva4.setRestaurante(restaurante3);
			reservaRepository.save(reserva4);
			
			Reserva reserva5 = new Reserva(5L,5000L,Timestamp.valueOf("2022-07-19 14:00:00"),12,true);
			reserva5.setCliente(cliente5);
			reserva5.setRestaurante(restaurante4);
			reservaRepository.save(reserva5);

// CLIENTES Y RESERVAS X RESTAURANTE			
			List<Cliente> clientesRest1 = new ArrayList<Cliente>();
			List<Cliente> clientesRest2 = new ArrayList<Cliente>();
			List<Cliente> clientesRest3 = new ArrayList<Cliente>();
			List<Cliente> clientesRest4 = new ArrayList<Cliente>();
			
			List<Reserva> reservasRest1 = new ArrayList<Reserva>();
			List<Reserva> reservasRest2 = new ArrayList<Reserva>();
			List<Reserva> reservasRest3 = new ArrayList<Reserva>();
			List<Reserva> reservasRest4 = new ArrayList<Reserva>();
			
			clientesRest1.add(cliente1);
			clientesRest1.add(cliente2);
			clientesRest1.add(cliente3);
			clientesRest1.add(cliente4);
						
			clientesRest2.add(cliente1);
			clientesRest2.add(cliente4);
			
			clientesRest3.add(cliente2);
			clientesRest3.add(cliente3);
			
			clientesRest4.add(cliente2);
			clientesRest4.add(cliente3);
			clientesRest4.add(cliente5);
			
			
			reservasRest1.add(reserva1);
			reservasRest1.add(reserva2);	
			reservasRest2.add(reserva3);
			reservasRest3.add(reserva4);
			reservasRest4.add(reserva5);
			
			restaurante1.setClientes(clientesRest1);
			restaurante1.setReservas(reservasRest1);
			restaurante2.setClientes(clientesRest2);
			restaurante2.setReservas(reservasRest2);
			restaurante3.setClientes(clientesRest3);
			restaurante3.setReservas(reservasRest3);
			restaurante4.setClientes(clientesRest4);
			restaurante4.setReservas(reservasRest4);
			
			restauranteRepository.save(restaurante1);
			restauranteRepository.save(restaurante2);
			restauranteRepository.save(restaurante3);
			restauranteRepository.save(restaurante4);

// RESTAURANTES Y RESERVAS X CLIENTE
			List<Restaurante> restCliente1 = new ArrayList<Restaurante>();
			List<Restaurante> restCliente2 = new ArrayList<Restaurante>();
			List<Restaurante> restCliente3 = new ArrayList<Restaurante>();
			List<Restaurante> restCliente4 = new ArrayList<Restaurante>();
			List<Restaurante> restCliente5 = new ArrayList<Restaurante>();
			
			List<Reserva> reservasCliente1 = new ArrayList<Reserva>();
			List<Reserva> reservasCliente2 = new ArrayList<Reserva>();
			List<Reserva> reservasCliente3 = new ArrayList<Reserva>();
			List<Reserva> reservasCliente4 = new ArrayList<Reserva>();
			List<Reserva> reservasCliente5 = new ArrayList<Reserva>();
			
			restCliente1.add(restaurante1);
			restCliente1.add(restaurante2);
			
			
			restCliente2.add(restaurante1);
			restCliente2.add(restaurante3);
			restCliente2.add(restaurante4);
			
			restCliente3.add(restaurante1);
			restCliente3.add(restaurante3);
			restCliente3.add(restaurante4);
			
			restCliente4.add(restaurante1);
			restCliente4.add(restaurante2);
			
			restCliente5.add(restaurante4);
			
			
			reservasCliente1.add(reserva1);
			reservasCliente2.add(reserva2);
			reservasCliente3.add(reserva4);
			reservasCliente4.add(reserva3);
			reservasCliente5.add(reserva5);
			
			cliente1.setRestaurantes(restCliente1);
			cliente1.setReservas(reservasCliente1);
			cliente2.setRestaurantes(restCliente2);
			cliente2.setReservas(reservasCliente2);
			cliente3.setRestaurantes(restCliente3);
			cliente3.setReservas(reservasCliente3);
			cliente4.setRestaurantes(restCliente4);
			cliente4.setReservas(reservasCliente4);
			cliente5.setRestaurantes(restCliente5);
			cliente5.setReservas(reservasCliente5);
			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);
			clienteRepository.save(cliente3);
			clienteRepository.save(cliente4);
			clienteRepository.save(cliente5);
			
			System.out.println("Datos cargardos con exito...");
		};
		
	}
	
}
