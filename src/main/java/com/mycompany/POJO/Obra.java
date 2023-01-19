/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.POJO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Estefania
 */
@Entity
@Table(name="Obras")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Obra implements Serializable{//Añadir clase creadores de la que herederán autores y directores
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" ,updatable = false, nullable = false)
    private int id;//PK
    
    @Column(name="titulo")
    private String titulo;
    
    @OneToMany(mappedBy="obra", cascade = CascadeType.ALL, fetch=FetchType.EAGER)//ACTUALIZARÁ Y BORRARÁ EN CASCADA A LAS COPIAS
    private Set<Copia> copias= new HashSet<Copia>();//FK
    
      public Obra() {
    }

    public Obra(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the copias
     */
    public Set<Copia> getCopias() {
        return copias;
    }

    /**
     * @param copias the copias to set
     */
    public void setCopias(Set<Copia> copias) {
        this.copias = copias;
    }
    
    
    
}
