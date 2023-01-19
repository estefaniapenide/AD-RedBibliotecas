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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author Estefania
 */
@Entity
@Table(name="Copias")
public class Copia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" ,updatable = false, nullable = false)
    private int id;//PK
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IdObra")
    private Obra obra;//FK
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IdBiblioteca")
    private Biblioteca biblioteca;//FK
    
    @Column(name="disponible")
    private boolean disponible;
    
//    cascade = CascadeType.ALL,
     @OneToMany(mappedBy = "copia", fetch=FetchType.LAZY)
    private Set<Prestamo> prestamos=new HashSet<Prestamo>();//FK
    
    public Copia(){}
    
    public Copia(Obra obra, Biblioteca biblioteca, boolean disponible){
        this.obra=obra;
        this.biblioteca=biblioteca;
        this.disponible=disponible;
                
    }

    /**
     * @return the biblioteca
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    /**
     * @param biblioteca the biblioteca to set
     */
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * @return the prestamos
     */
    public Set<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * @param prestamos the prestamos to set
     */
    public void setPrestamos(Set<Prestamo> prestamos) {
        this.prestamos = prestamos;
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
     * @return the libro
     */
    public Obra getObra() {
        return obra;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(Obra obra) {
        this.obra = obra;
    }

    /**
     * @return the disponible
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    @Override
    public String toString() {
        String copia = "ID COPIA: " + this.id
                + ", TÍTULO: " + this.obra.getTitulo()
                + ", DISPONIBLE: " + this.disponible
                + ", BIBLIOTECA: " + this.biblioteca.getNombre();
        return copia;
    }
    
}
