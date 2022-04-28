package com.proyecto.app.entidades;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reserva")
public class Reserva {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic
	@Column(name="id", nullable = false, unique = true)
	private long id;
	
	@Column(name="codigo", nullable = false, unique = true)
	private Long codigo;
	
	@Column(name="Fecha", nullable = false, unique = false)
	private Timestamp fecha;
	
	@Basic
	@Column(name="Cantidad", nullable = true, unique = false)
	private long cantidadClientes;
	
	@Column(name="Estado", nullable = false, unique = false)
	private boolean estado;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER) 
	private Restaurante restaurante;
	
	public Reserva() {
		
	}
	
	public Reserva(long id, Long codigo, Timestamp fecha, long cantidadClientes, boolean estado) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cantidadClientes = cantidadClientes;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Timestamp getFecha()
	{
		return fecha;
	}
	public void setFecha(Timestamp fecha)
	{
		this.fecha=fecha;
	}
	public long getCantidadClientes() {
		return cantidadClientes;
	}

	public void setCantidadClientes(long cantidadClientes) {
		this.cantidadClientes = cantidadClientes;
	}
	
	public boolean getEstado()
	{
		return estado;
	}
	
	public void setEstado(boolean estado)
	{
		this.estado=estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
}
