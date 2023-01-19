/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Operaciones;

import com.mycompany.Cadenas.Cadenas;
import com.mycompany.ControlData.ControlData;
import com.mycompany.POJO.Copia;
import com.mycompany.POJO.Prestamo;
import com.mycompany.POJO.Socio;
import com.mycompany.Sesiones.Sesiones;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import my.company.CRUD.CopiaCRUD;
import my.company.CRUD.PrestamoCRUD;
import my.company.CRUD.SocioCRUD;

/**
 *
 * @author Estefania
 */
public class Modificaciones {

    public static void menuModificaciones(Scanner input) {

        byte op = 0;
        do {
            Cadenas.menuModificaciones();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    mostrarPrestamos();
                    modificarPrestamo(input);
                    break;
                case 2:
                    modificarNombreSocio(input);
                    break;
                case 3:
                    modificarMultaSocio(input);
                    break;
                case 0:
                    Cadenas.menuAnterior();
                    break;
                default:
                    Cadenas.mensajeDefault();
                    break;
            }

        } while (op != 0);
    }

    private static void mostrarPrestamos() {
        Cadenas.prestamosActivos();
        List<Prestamo> prestamos = PrestamoCRUD.obtenerPrestamos();
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }

    private static void modificarPrestamo(Scanner input) {

        Cadenas.addevolucion();

        Cadenas.dni();
        String dni = ControlData.leerString(input);
        Socio socio = SocioCRUD.obtenerSocio(dni);

        Cadenas.idCopia();
        int idCopia = ControlData.leerInt(input);
        Copia copia = CopiaCRUD.obtenerCopia(idCopia);

        Cadenas.fechaPrestamo();
        String fp = ControlData.leerFechaTrucada(input);
        Date fechaPrestamo = Date.valueOf(fp);

        Cadenas.horaPrestamo();
        String hp = ControlData.leerHora(input);
        Time horaPrestamo = Time.valueOf(hp);

        Prestamo p = new Prestamo(socio, copia, fechaPrestamo, horaPrestamo);

        Prestamo prestamo = PrestamoCRUD.obtenerPrestamo(p);

        if (!Objects.isNull(prestamo)) {

            PrestamoCRUD.addDevolucion(prestamo);
            
            //Muestro la devolución actualizada
            Prestamo devolucion = PrestamoCRUD.obtenerPrestamo(p);
            System.out.println("\n\tDATOS ACTUALIZADOS");
            System.out.println("\n" + devolucion);
            System.out.println("\n" + devolucion.getCopia());
            System.out.println(devolucion.getSocio());

            Sesiones.borrar(devolucion);//Para evitar problemas al borrar socios y copias. Ya queda guardado en el log

        } else {
            Cadenas.prestamoNoExiste();
        }

    }

    public static void modificarNombreSocio(Scanner input) {

        Cadenas.socio();

        Cadenas.dni();
        String dni = ControlData.leerDni(input);

        Socio socio = SocioCRUD.obtenerSocio(dni);
        System.out.println(socio);

        Cadenas.nuevoNombre();
        String nuevoNombre = ControlData.leerString(input).toUpperCase();

        socio.setNombreCompleto(nuevoNombre);
        Sesiones.actualizar(socio);
        Cadenas.nombreModificado();

        Socio socioModificado = SocioCRUD.obtenerSocio(dni);
        System.out.println(socioModificado);
    }

    public static void modificarMultaSocio(Scanner input) {

        Cadenas.socio();

        Cadenas.dni();
        String dni = ControlData.leerDni(input);
        Socio socio = SocioCRUD.obtenerSocio(dni);

        System.out.println(socio);

        if (socio.isMulta()) {

            byte op = 0;
            do {
                Cadenas.menuMulta("QUITAR");
                op = ControlData.leerByte(input);
                switch (op) {
                    case 1:
                        socio.setFechaMulta(null);
                        socio.setMulta(false);
                        Sesiones.actualizar(socio);
                        Cadenas.multaEliminada();
                        break;
                    case 2:
                        break;
                    default:
                        Cadenas.mensajeDefault();
                        break;
                }
            } while (op != 1 && op != 2);

        } else if (!socio.isMulta()) {

            byte op = 0;
            do {
                Cadenas.menuMulta("AÑADIR");
                op = ControlData.leerByte(input);
                switch (op) {
                    case 1:
                        Cadenas.fechaMulta();
                        String fmulta = ControlData.leerFechaTrucada(input);
                        Date fechaMulta = Date.valueOf(fmulta);
                        socio.setFechaMulta(fechaMulta);
                        socio.setMulta(true);
                        Sesiones.actualizar(socio);
                        Cadenas.multaAdded();
                        break;
                    case 2:
                        break;
                    default:
                        Cadenas.mensajeDefault();
                        break;
                }
            } while (op != 1 && op != 2);
            
        }
        
         Socio socioModificado = SocioCRUD.obtenerSocio(dni);
            System.out.println(socioModificado);
    }

}
