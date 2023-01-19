/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.POJO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Estefania
 */
@Entity
@PrimaryKeyJoinColumn(name = "IdDVD")
@Table(name = "DVDs")
public class DVD extends Obra implements Serializable {

    @Column(name = "director")
    private String director;

    public DVD() {
    }

    public DVD(String titulo, String director) {
        super(titulo);
        this.director = director;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }
    
     @Override
    public String toString() {
        String libro = "\nTÍTULO: " + getTitulo()
                + "\nDIRECTOR: " + director;
        return libro;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof DVD) {
            return ((DVD) object).getTitulo().equals(super.getTitulo()) && ((DVD) object).getDirector().equals(director);
        }
        return super.equals(object);

    }

    @Override
    public int hashCode() {
        return 1;
    }

}
