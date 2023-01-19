/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Estefania
 */
@Entity
@Table(name = "Bibliotecas")
public class Biblioteca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;//PK

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Copia> copias = new HashSet<Copia>();//FK


    public Biblioteca() {
    }

    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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


    @Override
    public String toString() {
        String biblioteca = "\nNOMBRE: " + nombre
                + "\nDIRECCIÓN: " + direccion;
        return biblioteca;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Biblioteca) {
            return ((Biblioteca) object).getNombre().equals(nombre);
        }
        return super.equals(object);

    }

    @Override
    public int hashCode() {
        return 1;
    }

}
