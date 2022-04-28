package com.proyecto.app.dtos;

import com.proyecto.app.entidades.Restaurante;

public class RestauranteDTO {
    private Long id;
    private Long codigo;
    private String nombre;
    private String descripcion;
    private String direccion;
    private Long numero;

    
	public RestauranteDTO() {
		super();
	}
	
	public RestauranteDTO(Restaurante restaurante) {
		super();
		this.id = restaurante.getId();
		this.codigo = restaurante.getCodigo();
		this.nombre = restaurante.getNombre();
		this.descripcion = restaurante.getDescripcion();
		this.direccion = restaurante.getDireccion();
		this.numero = restaurante.getNumero();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre(){
        return nombre;
    }
	
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public Long getNumero(){
        return numero;
    }
    
    public void setNumero(Long numero){
        this.numero = numero;
    }
    
    public String getDescripcion()
    {
    	return descripcion;
    }
    
    public void setDescripcion(String descripcion)
    {
    	this.descripcion=descripcion;
    }
    
}
