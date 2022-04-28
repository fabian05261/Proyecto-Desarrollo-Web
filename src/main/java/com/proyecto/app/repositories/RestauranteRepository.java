package com.proyecto.app.repositories;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.app.entidades.Cliente;
import com.proyecto.app.entidades.Restaurante;

@Repository 
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
	
	@Query(value = "SELECT r FROM Restaurante r WHERE r.nombre = ?1")
	Restaurante getByNombre(String nombre);
	
	@Query(value = "SELECT r FROM Restaurante r WHERE r.id = ?1")
	Restaurante getById(Long id);
	
	@Query(value = "SELECT r FROM Restaurante r WHERE r.descripcion LIKE %?1%")
	List<Restaurante> findByDescripcionContaining(String descripcion);
	
	@Query(value = "SELECT r FROM Restaurante r JOIN r.clientes cliente WHERE cliente = ?1 ")
	List<Restaurante> findRestauranteByCliente(Cliente cliente); 
	
	@Query(value = "SELECT r FROM Restaurante r JOIN r.reservas reservas WHERE reservas.fecha = ?1 ")
	List<Restaurante> findRestauranteByReserva(Timestamp fecha); 
	
	@Query("SELECT r FROM Restaurante r JOIN r.reservas reservas WHERE reservas.fecha BETWEEN :inicio AND :fin")
	List<Restaurante> findReservaByDate(@Param(value = "inicio") Timestamp fecha1, @Param(value = "fin") Timestamp fecha2);
	
}
