package com.proyecto.app.entidades;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name="id", nullable = false, unique = true)
    private Long id;
    
    @Column(name="Codigo", nullable = false, unique = true)
    private Long codigo;
    
    @Column(name="Nombre", nullable = true, unique = false)
    private String nombre;
    
    @Column(name="Correo", nullable = true, unique = false)
    private String correo;
    
    @Column(name="Numero", nullable = true, unique = false)
    private String numero;
    
    @Column(name="Reservas", nullable = true, unique = false)
	@OneToMany(fetch=FetchType.EAGER)
    private List<Reserva> reservas;
        
    @ManyToMany(fetch=FetchType.EAGER)
    @Column(name="Restaurantes",nullable=true,unique=true)
    private List<Restaurante>restaurantes;
    
    public Cliente(){

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

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}
    
}