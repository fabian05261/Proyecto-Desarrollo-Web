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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Restaurante")
public class Restaurante{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name="id", nullable = false, unique = true)
    private Long id;
    
    @Basic
    @Column(name = "Codigo", nullable = false, unique = true)
    private Long codigo;
    
    @Column(name="Nombre", nullable = false, unique = false)
    private String nombre;
    
	@Column(name="Descripcion", nullable = true, unique = false)
    private String descripcion;
    
    @Column(name="Direccion", nullable = true, unique = false)
    private String direccion;
    
    @Column(name="Numero", nullable = true, unique = false)
    private Long numero;
    
    @Column(name="Reservas", nullable = true, unique = false)
    @OneToMany(fetch=FetchType.EAGER)
    private List<Reserva> reservas;
    
    @Column(name="Clientes", nullable = true, unique = false)
    @ManyToMany(fetch=FetchType.EAGER)
    private List<Cliente> clientes;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Administrador administrador;
    
    public Restaurante()
    {

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

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
    


}