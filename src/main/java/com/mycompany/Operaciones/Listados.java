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
import com.mycompany.POJO.Prestamo;
import com.mycompany.POJO.Socio;
import java.sql.Date;
import java.util.List;
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
public class Listados {

    public static void menuListados(Scanner input) {

        byte op = 0;
        do {
            Cadenas.menuListados();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    mostrarTodasBibliotecas();
                    break;
                case 2:
                    mostrarTodosSocios();
                    break;
                case 3:
                    mostrarTodosLibros();
                    break;
                case 4:
                    mostrarTodosDVDs();
                    break;
                case 5:
                    mostrarTodosPrestamos();
                    break;
                case 6:
                    catalogoBiblioteca(input);
                    break;
                case 7:
                    librosAutor(input);
                    break;
                case 8:
                    prestamosSocioFechas(input);
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

    public static void mostrarTodasBibliotecas() {

        Cadenas.todasBibliotecas();

        List<Biblioteca> bibliotecas = BibliotecaCRUD.obtenerBibliotecas();

        for (Biblioteca biblioteca : bibliotecas) {
            System.out.println(biblioteca);
        }
    }

    public static void mostrarTodosSocios() {

        Cadenas.todosSocios();

        List<Socio> socios = SocioCRUD.obtenerSocios();

        for (Socio socio : socios) {
            System.out.println(socio);
        }
    }

    public static void mostrarTodosLibros() {

        Cadenas.todosLibros();

        List<Libro> libros = LibroCRUD.obtenerLibros();

        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public static void mostrarTodosDVDs() {

        Cadenas.todosDVDs();

        List<DVD> DVDs = DVDCRUD.obtenerDVDs();

        for (DVD dvd : DVDs) {
            System.out.println(dvd);
        }
    }

    public static void mostrarTodosPrestamos() {
        Cadenas.prestamosActivos();

        List<Prestamo> prestamos = PrestamoCRUD.obtenerPrestamos();
        System.out.println();

        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }

    public static void catalogoBiblioteca(Scanner input) {
        Cadenas.biblioteca();
        Cadenas.nombre();
        String nombreBiblioteca = ControlData.leerString(input).toUpperCase();

        Biblioteca biblioteca = BibliotecaCRUD.obtenerBiblioteca(nombreBiblioteca);
        if (!Objects.isNull(biblioteca)) {

            System.out.println();

            List<Copia> copias = CopiaCRUD.obtenerCopias(biblioteca);
            for (Copia copia : copias) {
                System.out.println(copia);
            }
        } else {
            Cadenas.bibliotecaNoExiste();
        }
    }

    public static void librosAutor(Scanner input) {
        Cadenas.autor();
        Cadenas.nombre();
        String nombre = ControlData.leerString(input).toUpperCase();

        Cadenas.apellidos();
        String apellidos = ControlData.leerString(input).toUpperCase();

        Autor a = new Autor(nombre, apellidos);
        Autor autor = AutorCRUD.obtenerAutor(a);

        if (!Objects.isNull(autor)) {
            for (Libro libro : autor.getLibros()) {
                System.out.println(libro);
            }
        } else {
            Cadenas.autorNoExiste();
        }

    }

    public static void prestamosSocioFechas(Scanner input) {
        
        Cadenas.socio();
        
        Cadenas.dni();
        String dni = ControlData.leerDni(input);
        Socio socio = SocioCRUD.obtenerSocio(dni);
        
        if (!Objects.isNull(socio)) {
            
            Cadenas.fechaPrestamo();
            String f1 = ControlData.leerFecha(input);

            Cadenas.fechaPrestamo();
            String f2 = ControlData.leerFecha(input);

            Date fp1 = Date.valueOf(f1);
            Date fp2 = Date.valueOf(f2);
            

            List<Prestamo> prestamos = PrestamoCRUD.obtenerPrestamosDeUnSocioDeDosFechas(socio, fp1, fp2);
            if (prestamos.isEmpty()) {
                System.out.println("\nNO REALIZÓ NINGÚN PRESTAMO EN NINGUNA DE LAS FECHAS INDICADAS");
            } else {
                Cadenas.prestamosActivos();
                for (Prestamo prestamo : prestamos) {
                    System.out.println(prestamo);
                }
            }

        } else {
            Cadenas.socioNoExiste();
        }
    }

}
