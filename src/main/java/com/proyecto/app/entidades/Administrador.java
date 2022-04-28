package com.proyecto.app.entidades;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.List;
@Entity
@Table(name = "Administrador")
public class Administrador{
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic
	@Column(name="id",length=5,nullable=true,unique=true)
    private Long id;
    
    @OneToMany(fetch=FetchType.EAGER)
    private List<Restaurante> restaurantes;
    
    @Column(name="Correo",nullable=true,unique=true)
    private String correo;
    
    @Column(name="Password",nullable=true,unique=true)
    private String password;
    public Administrador(){

    }
    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}