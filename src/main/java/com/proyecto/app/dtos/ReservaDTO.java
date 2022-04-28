package com.proyecto.app.dtos;

import java.sql.Timestamp;

import com.proyecto.app.entidades.Reserva;

public class ReservaDTO {

	private long id;
	private Long codigo;
	private Timestamp fecha;
	private long cantidadClientes;
	private boolean estado;

	
	public ReservaDTO() {
		super();
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

	public ReservaDTO(Reserva reserva) {
		super();
		this.id = reserva.getId();
		this.codigo = reserva.getCodigo();
		this.fecha = reserva.getFecha();
		this.cantidadClientes = reserva.getCantidadClientes();
		this.estado = reserva.getEstado();
	}
	
	
	
	
}
