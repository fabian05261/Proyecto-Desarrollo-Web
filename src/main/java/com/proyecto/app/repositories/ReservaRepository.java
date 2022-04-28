package com.proyecto.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.app.entidades.Reserva;


import java.sql.Timestamp;
import java.util.List;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	@Query(value = "SELECT r FROM Reserva r WHERE r.id = ?1")
	Reserva getById(Long id);
	
	@Query(value = "SELECT r FROM Reserva r JOIN r.cliente cliente WHERE cliente.id = ?1")
	List<Reserva> findReservasByCliente(Long clienteID);
	
	@Query(value = "SELECT r FROM Reserva r JOIN r.cliente cliente WHERE cliente.id = ?1 ORDER BY r.fecha" )
	List<Reserva> findByClienteOrdenByFecha(Long clienteID);
	
	@Query(value = "SELECT r FROM Reserva r JOIN r.restaurante rest WHERE rest.id = ?1")
	List<Reserva> findReservasByRestaurante(Long restauranteID);
	
	@Query(value = "SELECT r FROM Reserva r JOIN r.restaurante rest WHERE rest.id = ?1 ORDER BY r.fecha" )
	List<Reserva> findByRestauranteOrderByFecha(Long restauranteID);
	
	@Query(value = "SELECT r FROM Reserva r WHERE r.fecha = ?1")
	List<Reserva> findReservasByFecha(Timestamp fecha);
	
	@Query("SELECT r FROM Reserva r WHERE r.fecha BETWEEN :inicio AND :fin")
	List<Reserva> findReservasByRango(@Param(value = "inicio") Timestamp fecha1, @Param(value = "fin") Timestamp fecha2);
	
	@Query("SELECT r FROM Reserva r WHERE r.cantidadClientes = ?1")
	List<Reserva> findByClientesEquals(Long cantidad);

	@Query("SELECT r FROM Reserva r WHERE r.cantidadClientes > ?1")
	List<Reserva> findByClientesGreaterThan(Long cantidad);
	
	@Query("SELECT r FROM Reserva r WHERE r.cantidadClientes < ?1")
	List<Reserva> findByClientesLessThan(Long cantidad);
	
	@Query("SELECT r FROM Reserva r WHERE r.cantidadClientes is null")
	List<Reserva> findByCantidadNull();
	
	List<Reserva> findByFechaAfter(Timestamp fecha);

	List<Reserva> findByFechaBefore(Timestamp fecha);

	List<Reserva> findByEstadoTrue();

	List<Reserva> findByEstadoFalse();
}
