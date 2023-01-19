/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author Estefania
 */
@Entity
@Table(name = "Socios")
@NamedQueries({
   @NamedQuery(name="socios", query="from Socio"),
})
public class Socio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;//PK
    
    @Column(name = "dni", unique = true, nullable = false)
    private String dni;//UNIQUE//PK

    @Column(name = "nombreCompleto")
    private String nombreCompleto;

    @Column(name = "maxCopias")
    private int MAX_COPIAS = 3;

    @Column(name = "numPrestamosActivos")
    private int numPrestamosActivos;

    @Column(name = "multa")
    private boolean multa = false;//Por defecto no tiene multa

    @Column(name = "fechaMulta")
    private Date fechaMulta;

    @OneToMany(mappedBy = "socio", fetch = FetchType.LAZY)//Igual necesita estar como EAGER.Cuidado
    private Set<Prestamo> prestamos = new HashSet<Prestamo>();//FK

    public Socio() {
    }

    public Socio(String dni, String nombreCompleto) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;

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
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the MAX_COPIAS
     */
    public int getMAX_COPIAS() {
        return MAX_COPIAS;
    }

    /**
     * @param MAX_COPIAS the MAX_COPIAS to set
     */
    public void setMAX_COPIAS(int MAX_COPIAS) {
        this.MAX_COPIAS = MAX_COPIAS;
    }

    /**
     * @return the numPrestamosActivos
     */
    public int getNumPrestamosActivos() {
        return numPrestamosActivos;
    }

    /**
     * @param numPrestamosActivos the numPrestamosActivos to set
     */
    public void setNumPrestamosActivos(int numPrestamosActivos) {
        this.numPrestamosActivos = numPrestamosActivos;
    }

    /**
     * @return the multa
     */
    public boolean isMulta() {
        return multa;
    }

    /**
     * @param multa the multa to set
     */
    public void setMulta(boolean multa) {
        this.multa = multa;
    }

    /**
     * @return the fechaMulta
     */
    public Date getFechaMulta() {
        return fechaMulta;
    }

    /**
     * @param fechaMulta the fechaMulta to set
     */
    public void setFechaMulta(Date fechaMulta) {
        this.fechaMulta = fechaMulta;
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
    
     @Override
    public String toString() {
        String socio = "\nDNI: " + dni
                + "\nNOMBRE COMPLETO: " + nombreCompleto
                + "\nNÚMERO DE PRÉSTAMOS ACTUALES: " + numPrestamosActivos
                + "\nMULTA: " + multa
                + "\nSANCIÓN HASTA: " + fechaMulta;
        return socio;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Libro) {
            return ((Socio) object).getDni().equals(dni);
        }
        return super.equals(object);

    }

    @Override
    public int hashCode() {
        return 1;
    }

}
