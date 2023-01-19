/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.POJO;

import java.io.Serializable;
import java.sql.Date;//Ojo con estos!!!
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Estefania
 */
@Entity
@Table(name = "Prestamos")
public class Prestamo implements Serializable {

    private Socio socio;//PK-FK
    private Copia copia;//PK-FK

    private Date fechaPrestamo;//PK
    private Time horaPrestamo;//PK

    private Date fechaDevolucion;
    private Date fechaDevuelto;
    

    public Prestamo() {
    }

    public Prestamo(Socio socio, Copia copia, Date fechaPrestamo, Time horaPrestamo) {
        this.socio = socio;
        this.copia = copia;
        this.fechaPrestamo = fechaPrestamo;
        this.horaPrestamo = horaPrestamo;
    }

    /**
     * @return the socio
     */
    @Id
    @ManyToOne(fetch = FetchType.EAGER)//Cambiado!!
    @JoinColumn(name = "IdSocio")
    public Socio getSocio() {
        return socio;
    }

    /**
     * @param socio the socio to set
     */
    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    /**
     * @return the copia
     */
    @Id
    @ManyToOne(fetch = FetchType.EAGER)//Cambiado!!
    @JoinColumn(name = "IdCopia")
    public Copia getCopia() {
        return copia;
    }

    /**
     * @param copia the copia to set
     */
    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    /**
     * @return the fechaPrestamo
     */
    @Id
    @Column(name = "fechaPrestamo")
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * @param fechaPrestamo the fechaPrestamo to set
     */
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * @return the horaPrestamo
     */
    @Id
    @Column(name = "horaPrestamo")
    public Time getHoraPrestamo() {
        return horaPrestamo;
    }

    /**
     * @param horaPrestamo the horaPrestamo to set
     */
    public void setHoraPrestamo(Time horaPrestamo) {
        this.horaPrestamo = horaPrestamo;
    }

    /**
     * @return the fechaDevolucion
     */
    @Column(name = "fechaDevolucion")
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * @param fechaDevolucion the fechaDevolucion to set
     */
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * @return the fechaDevuelto
     */
    @Column(name = "fechaDevuelto")
    public Date getFechaDevuelto() {
        return fechaDevuelto;
    }

    /**
     * @param fechaDevuelto the fechaDevuelto to set
     */
    public void setFechaDevuelto(Date fechaDevuelto) {
        this.fechaDevuelto = fechaDevuelto;
    }

    @Override
    public String toString() {
   
        String prestamo = "DNI SOCIO: " + this.socio.getDni()
                + ", ID COPIA: " + this.copia.getId()
                + ", FECHA PRÉSTAMO: " + this.fechaPrestamo
                + ", HORA PRÉSTAMO: " + this.horaPrestamo
                + ", FECHA HASTA: " + this.fechaDevolucion
                + ", FECHA DEVUELTO: " + this.fechaDevuelto;
        return prestamo;
    }

}
