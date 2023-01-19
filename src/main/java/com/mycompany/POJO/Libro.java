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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author Estefania
 */
@Entity
@PrimaryKeyJoinColumn(name = "IdLibro")
@Table(name = "Libros")
public class Libro extends Obra implements Serializable {

    
    @ManyToMany(fetch = FetchType.EAGER)//Funciona!!
    @JoinTable(name = "LibrosAutores", joinColumns = {
        @JoinColumn(name = "IdLibro")}, inverseJoinColumns = {
        @JoinColumn(name = "IdAutor")})
    private Set<Autor> autores = new HashSet<Autor>();

    @Column(name = "editorial")
    private String editorial;

    public Libro() {
    }

    public Libro(String titulo, String editorial) {
        super(titulo);
        this.editorial = editorial;
    }


    /**
     * @return the autores
     */
    public Set<Autor> getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        StringBuilder autores = new StringBuilder();
        for(Autor autor: this.autores){
        autores.append(autor.getNombre());
        autores.append(" ");
        autores.append(autor.getApellidos());
        autores.append("   ");
        }
        String libro = "\nTÍTULO: " + getTitulo()
                + "\nEDITORIAL: " + editorial
                + "\nAUTORES: " + autores;
        return libro;
    }


    @Override
    public boolean equals(Object object) {
        if (object instanceof Libro) {
            return ((Libro) object).getTitulo().equals(super.getTitulo()) && ((Libro) object).getAutores().equals(autores) && ((Libro) object).getEditorial().equals(editorial);
        }
        return super.equals(object);

    }


    @Override
    public int hashCode() {
        return 1;
    }

}
