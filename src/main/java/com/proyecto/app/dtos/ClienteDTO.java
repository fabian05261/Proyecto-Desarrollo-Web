package com.proyecto.app.dtos;

import com.proyecto.app.entidades.Cliente;

public class ClienteDTO {

    private Long id;
    private Long codigo;
    private String nombre;
    private String correo;
    private String numero;
   
    
    public ClienteDTO() {
		super();
	}
    
    

	public ClienteDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.codigo = cliente.getCodigo();
		this.nombre = cliente.getNombre();
		this.correo = cliente.getCorreo();
		this.numero = cliente.getNumero();
	}



	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public String getNumero(){
        return numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    
}
