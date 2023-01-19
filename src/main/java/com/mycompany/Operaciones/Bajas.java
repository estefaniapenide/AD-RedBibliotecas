/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Operaciones;

import com.mycompany.Cadenas.Cadenas;
import com.mycompany.ControlData.ControlData;
import com.mycompany.POJO.Biblioteca;
import com.mycompany.POJO.Copia;
import com.mycompany.POJO.DVD;
import com.mycompany.POJO.Libro;
import com.mycompany.POJO.Obra;
import com.mycompany.POJO.Prestamo;
import com.mycompany.POJO.Socio;
import com.mycompany.Sesiones.Sesiones;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import my.company.CRUD.BibliotecaCRUD;
import my.company.CRUD.CopiaCRUD;
import my.company.CRUD.DVDCRUD;
import my.company.CRUD.LibroCRUD;
import my.company.CRUD.SocioCRUD;
import org.hibernate.Session;

/**
 *
 * @author Estefania
 */
public class Bajas {

    public static void menuBajas(Scanner input) {
//        Socio s1 = null;
//        Copia c1 = null;

        byte op = 0;
        do {
            Cadenas.menuBajas();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    bajaBiblioteca(input);
                    break;
                case 2:
                    menuBajaObras(input);
                    break;
                case 3:
                    bajaCopia(input);
                    break;
                case 4:
                    bajaSocio(input);
                    break;

                case 0:
//                    System.out.println("dni socio:");
//                    String d = ControlData.leerDni(input);
//                    s1 = SocioCRUD.obtenerSocio(d);
//                    c1 = CopiaCRUD.obtenerCopia(12);
//                    Prestamo p1 = new Prestamo(s1, c1, fprestamo, horaPrestamo);
//                    p1.setFechaDevolucion(fdevolucion);
////                    s1.setNumPrestamosActivos(1);
////                    c1.setDisponible(false);
//                    Sesiones.guardar(p1);
////                    Prestamo p2 = new Prestamo(s1,c1,fprestamo,horaPrestamo);
////                    Sesiones.borrar(p2);
                    Cadenas.menuAnterior();
                    ;
                    break;
                default:
                    Cadenas.mensajeDefault();
                    break;
            }

        } while (op != 0);
    }

    private static void bajaBiblioteca(Scanner input) {

        Cadenas.biblioteca();

        Cadenas.nombre();
        String nombreBiblioteca = ControlData.leerString(input).toUpperCase();

        Biblioteca biblioteca = BibliotecaCRUD.obtenerBiblioteca(nombreBiblioteca);

        if (!Objects.isNull(biblioteca)) {

            if (!CopiaCRUD.hayCopiasPrestadas(biblioteca)) {

                Sesiones.borrar(biblioteca);
                Cadenas.bibliotecaBorrada();
            } else {

                System.out.println("NO SE PUEDE DAR DE BAJA LA BIBLIOTECA PORQUE TIENE COPIAS PRESTADAS");
            }

        } else {
            Cadenas.bibliotecaNoExiste();
        }

    }

    private static void menuBajaObras(Scanner input) {
        Cadenas.bajaObra();

        byte op = 0;
        do {
            Cadenas.menuObras();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    bajaLibro(input);
                    break;
                case 2:
                    bajaDVD(input);
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

    private static void bajaLibro(Scanner input) {//TAMBIÉN DARÁ DE BAJA TODAS SUS COPIAS

        Cadenas.libro();

        Cadenas.titulo();
        String titulo = ControlData.leerString(input).toUpperCase();


        Cadenas.editorial();
        String editorial = ControlData.leerString(input);

        Obra libro = LibroCRUD.obtenerLibro(titulo, editorial);
        

        if (!Objects.isNull(libro)) {

            if (!CopiaCRUD.hayCopiasPrestadas(libro)) {

                Sesiones.borrar(libro);
                Cadenas.libroBorrado();
            } else {
                System.out.println("NO SE PUEDE DAR DE BAJA LA OBRA PORQUE TIENE COPIAS PRESTADAS");
            }
        } else {
            Cadenas.libroNoExiste();

        }

    }

    private static void bajaDVD(Scanner input) {//TAMBIÉN DARÁ DE BAJA TODAS SUS COPIAS

        Cadenas.DVD();

        Cadenas.titulo();
        String titulo = ControlData.leerString(input).toUpperCase();

        Cadenas.director();
        String director = ControlData.leerString(input).toUpperCase();

        Obra dvd = DVDCRUD.obtenerDVD(titulo, director);

        if (!Objects.isNull(dvd)) {

            if (!CopiaCRUD.hayCopiasPrestadas(dvd)) {

                Sesiones.borrar(dvd);
                Cadenas.DVDBorrado();
            } else {
                System.out.println("NO SE PUEDE DAR DE BAJA LA OBRA PORQUE TIENE COPIAS PRESTADAS");
            }
        } else {
            Cadenas.DVDNoExiste();

        }

    }

    private static void bajaCopia(Scanner input) {

        Cadenas.bajaCopia();
        Cadenas.idCopia();
        int idCopia = ControlData.leerInt(input);

        Copia copia = CopiaCRUD.obtenerCopia(idCopia);

        if (!Objects.isNull(copia)) {
            if (copia.isDisponible()) {
                Sesiones.borrar(copia);
                Cadenas.copiaBorrada();
            } else {
                System.out.println("LA COPIA ESTÁ PRESTADA. NO SE PUEDE BORRAR");
            }
        } else {
            Cadenas.copiaNoExiste();
        }
    }

    private static void bajaSocio(Scanner input) {

        Cadenas.socio();
        Cadenas.dni();
        String dni = ControlData.leerDni(input);

        Socio socio = SocioCRUD.obtenerSocio(dni);

        if (!Objects.isNull(socio)) {

            if (socio.getNumPrestamosActivos() == 0) {

                System.out.println(socio);
                byte op = 1;
                do {
                    Cadenas.confirmarBorrarSocio();
                    op = ControlData.leerByte(input);
                    switch (op) {
                        case 1:
                            Sesiones.borrar(socio);
                            Cadenas.socioBorrado();
                            break;
                        case 2:
                            break;
                        default:
                            Cadenas.mensajeDefault();
                            break;
                    }
                } while (op != 2 && op != 1);
            } else {
                System.out.println("EL SOCIO TIENE PRÉSTAMOS PENDIENTES. NO SE PUEDE DAR DE BAJA");
            }
        } else {
            Cadenas.socioNoExiste();

        }
    }

}
