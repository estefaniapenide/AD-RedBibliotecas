/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Operaciones;

import com.mycompany.Cadenas.Cadenas;
import com.mycompany.ControlData.ControlData;
import com.mycompany.POJO.Autor;
import com.mycompany.POJO.Biblioteca;
import com.mycompany.POJO.Copia;
import com.mycompany.POJO.DVD;
import com.mycompany.POJO.Libro;
import com.mycompany.POJO.Obra;
import com.mycompany.POJO.Prestamo;
import com.mycompany.POJO.Socio;
import com.mycompany.Sesiones.Sesiones;
import java.util.Objects;
import java.util.Scanner;
import my.company.CRUD.AutorCRUD;
import my.company.CRUD.BibliotecaCRUD;
import my.company.CRUD.CopiaCRUD;
import my.company.CRUD.DVDCRUD;
import my.company.CRUD.LibroCRUD;
import my.company.CRUD.PrestamoCRUD;
import my.company.CRUD.SocioCRUD;

/**
 *
 * @author Estefania
 */
public class Altas {

    public static void menuAltas(Scanner input) {

        byte op = 0;
        do {
            Cadenas.menuAltas();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    altaBiblioteca(input);
                    break;
                case 2:
                    menuAltaObras(input);
                    break;
                case 3:
                    altaAutor(input);
                    break;
                case 4:
                    menuAltaCopia(input);
                    break;
                case 5:
                    altaSocio(input);
                    break;
                case 6:
                    altaPrestamo(input);
                    break;
                case 0:
                    Cadenas.menuAnterior();
                    ;
                    break;
                default:
                    Cadenas.mensajeDefault();
                    break;
            }

        } while (op != 0);
    }

    private static void altaBiblioteca(Scanner input) {

        Cadenas.biblioteca();

        Cadenas.nombre();
        String nombreBiblioteca = ControlData.leerString(input).toUpperCase();

        Biblioteca biblioteca = BibliotecaCRUD.obtenerBiblioteca(nombreBiblioteca);

        if (Objects.isNull(biblioteca)) {
            Cadenas.direccion();
            String direccion = ControlData.leerString(input).toUpperCase();

            biblioteca = new Biblioteca(nombreBiblioteca, direccion);
            Sesiones.guardar(biblioteca);
//            SocioCRUD.AddBibliotecaATodosSocios(biblioteca);
        } else {
            Cadenas.bibliotecaYaExiste();
            System.out.println(biblioteca);
        }

    }

    private static void menuAltaObras(Scanner input) {
        Cadenas.altaObra();
        byte op = 0;
        do {
            Cadenas.menuObras();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    altaLibro(input);
                    break;
                case 2:
                    altaDVD(input);
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

    private static void altaLibro(Scanner input) {

        Cadenas.libro();

        Cadenas.titulo();
        String titulo = ControlData.leerString(input).toUpperCase();

        Cadenas.editorial();
        String editorial = ControlData.leerString(input);

        Libro libro = LibroCRUD.obtenerLibro(titulo, editorial);

        if (Objects.isNull(libro)) {
            
            libro = new Libro(titulo, editorial);
            
            byte op = 0;
            do {
                Cadenas.menuAutores();
                op = ControlData.leerByte(input);
                switch (op) {
                    case 1:
                        nuevoAutor(input, libro);
                        break;
                    case 2:
                        break;
                    default:
                        Cadenas.mensajeDefault();
                        break;
                }
            } while (op != 2);

            Sesiones.guardar(libro);
            Cadenas.libroAdded();
        } else {
            Cadenas.libroYaExiste();
            System.out.println(libro);
        }

    }

    private static void nuevoAutor(Scanner input, Libro libro) {
        Cadenas.autor();

        Cadenas.nombre();
        String nombre = ControlData.leerString(input).toUpperCase();

        Cadenas.apellidos();
        String apellidos = ControlData.leerString(input).toUpperCase();

        Autor a = new Autor(nombre, apellidos);
        Autor autor = AutorCRUD.obtenerAutor(a);

        if (!Objects.isNull(autor)) {
            libro.getAutores().add(autor);

        } else {
            Cadenas.nacionalidad();
            String nacionalidad = ControlData.leerString(input);
            a.setNacionalidad(nacionalidad);

            Sesiones.guardar(a);
            libro.getAutores().add(a);

        }
    }

    private static void altaDVD(Scanner input) {

        Cadenas.DVD();

        Cadenas.titulo();
        String titulo = ControlData.leerString(input).toUpperCase();

        Cadenas.director();
        String director = ControlData.leerString(input).toUpperCase();

        Obra dvd = DVDCRUD.obtenerDVD(titulo, director);

        if (Objects.isNull(dvd)) {
            dvd = new DVD(titulo, director);
            Sesiones.guardar(dvd);
            Cadenas.DVDAdded();
        } else {
            Cadenas.DVDYaExiste();
            System.out.println(dvd);
        }

    }

    private static void menuAltaCopia(Scanner input) {

        Cadenas.altaCopia();
        byte op = 0;
        do {
            Cadenas.menuObras();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    altaCopiaLibro(input);
                    break;
                case 2:
                    altaCopiaDVD(input);
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

    private static void altaCopiaLibro(Scanner input) {

        Cadenas.libro();

        Cadenas.titulo();
        String titulo = ControlData.leerString(input).toUpperCase();

        Cadenas.editorial();
        String editorial = ControlData.leerString(input);

        Obra libro = LibroCRUD.obtenerLibro(titulo, editorial);


        if (!Objects.isNull(libro)) {

            Cadenas.biblioteca();
            Cadenas.nombre();
            String nombreBiblioteca = ControlData.leerString(input).toUpperCase();

            Biblioteca biblioteca = BibliotecaCRUD.obtenerBiblioteca(nombreBiblioteca);

            if (!Objects.isNull(biblioteca)) {

                Copia copia = new Copia(libro, biblioteca, true);
                Sesiones.guardar(copia);
                Cadenas.copiaAdded();

            } else {
                Cadenas.bibliotecaNoExiste();
            }

        } else {
            Cadenas.libroNoExiste();
        }
    }

    private static void altaCopiaDVD(Scanner input) {

        Cadenas.DVD();

        Cadenas.titulo();
        String titulo = ControlData.leerString(input).toUpperCase();

        Cadenas.director();
        String director = ControlData.leerString(input).toUpperCase();

        Obra dvd = DVDCRUD.obtenerDVD(titulo, director);

        if (!Objects.isNull(dvd)) {

            Cadenas.biblioteca();
            Cadenas.nombre();
            String nombreBiblioteca = ControlData.leerString(input).toUpperCase();

            Biblioteca biblioteca = BibliotecaCRUD.obtenerBiblioteca(nombreBiblioteca);

            if (!Objects.isNull(biblioteca)) {

                Copia copia = new Copia(dvd, biblioteca, true);
                Sesiones.guardar(copia);
                Cadenas.copiaAdded();

            } else {
                Cadenas.bibliotecaNoExiste();
            }

        } else {
            Cadenas.DVDNoExiste();
        }
    }

    private static void altaSocio(Scanner input) {

        Cadenas.socio();
        Cadenas.dni();
        String dni = ControlData.leerDni(input);

        Socio socio = SocioCRUD.obtenerSocio(dni);

        if (Objects.isNull(socio)) {

            Cadenas.nombreCompleto();
            String nombreCompleto = ControlData.leerString(input).toUpperCase();

            socio = new Socio(dni, nombreCompleto);

            Sesiones.guardar(socio);
//            BibliotecaCRUD.AddSocioATodasBibliotecas(socio);
            Cadenas.socioAdded();

        } else {
            Cadenas.socioYaExiste();
            System.out.println(socio);
        }
    }

    private static void altaPrestamo(Scanner input) {

        Cadenas.prestamo();

        Cadenas.socio();

        Cadenas.dni();
        String dni = ControlData.leerDni(input);
        Socio socio = SocioCRUD.obtenerSocio(dni);

        if (!Objects.isNull(socio)) {
            if ((socio.getNumPrestamosActivos() < socio.getMAX_COPIAS()) && !socio.isMulta()) {
                Cadenas.copia();
                Cadenas.idCopia();
                int idCopia = ControlData.leerInt(input);

                Copia copia = CopiaCRUD.obtenerCopia(idCopia);
                if (!Objects.isNull(copia)) {

                    if (copia.isDisponible()) {
                        int prestamos = socio.getNumPrestamosActivos() + 1;
                        socio.setNumPrestamosActivos(prestamos);
                        copia.setDisponible(false);
                        Sesiones.actualizar(socio);
                        Sesiones.actualizar(copia);
                        PrestamoCRUD.nuevoPrestamo(socio, copia);
                        Cadenas.prestamoAdded();
                    } else {
                        Cadenas.copiaNoDisponible();
                    }

                } else {
                    Cadenas.copiaNoExiste();
                }
            } else {
                System.out.println("EL SOCIO NO PUEDE COGER MÁS OBRAS PRESTADAS HASTA QUE DEVUELVA ALGUNA Y/O VENZA SU FECHA DE MULTA");
            }
        } else {
            Cadenas.socioNoExiste();
        }

    }

    private static void altaAutor(Scanner input) {

        Cadenas.autor();

        Cadenas.nombre();
        String nombre = ControlData.leerString(input).toUpperCase();

        Cadenas.apellidos();
        String apellidos = ControlData.leerString(input).toUpperCase();

        Autor a = new Autor(nombre, apellidos);
        Autor autor = AutorCRUD.obtenerAutor(a);

        if (Objects.isNull(autor)) {

            Cadenas.nacionalidad();
            String nacionalidad = ControlData.leerString(input);
            a.setNacionalidad(nacionalidad);

            Sesiones.guardar(a);
            Cadenas.autorAdded();

        } else {

            Cadenas.autorYaExiste();
            System.out.println(autor);

        }
    }

}
