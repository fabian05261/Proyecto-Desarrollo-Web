package com.proyecto.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.proyecto.app.entidades.Cliente;

import java.util.Optional;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query(value="select c from Cliente c where c.nombre=?1")
	Optional<Cliente> getByNombre (String nombre);
		
	@Query(value="select c from Cliente c where c.nombre = ?1 order by c.nombre asc")
	Optional<Cliente> getByNombreOrderByNombreAsc(String nombre); 
	
	@Query(value = "SELECT c FROM Cliente c WHERE c.id = ?1")
	Cliente getById(Long id);

	@Query(value = "SELECT c FROM Cliente c WHERE c.correo = ?1")
	Cliente getByCorreo(String correo);
	
	@Query(value = "SELECT c FROM Cliente c JOIN c.restaurantes r WHERE r.id = ?1 ")
	List<Cliente> findClienteByRestaurante(Long restauranteID); 
	
	@Query(value = "SELECT c FROM Cliente c JOIN c.reservas reservas WHERE reservas.fecha = ?1 ")
	List<Cliente> findClientesByFecha(Timestamp fecha); 
	
	@Query("SELECT c FROM Cliente c JOIN c.reservas reservas WHERE reservas.fecha BETWEEN :inicio AND :fin")
	List<Cliente> findClientesByRango(@Param(value = "inicio") Timestamp fecha1, @Param(value = "fin") Timestamp fecha2);
}
