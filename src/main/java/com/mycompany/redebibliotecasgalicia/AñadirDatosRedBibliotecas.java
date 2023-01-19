/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.redebibliotecasgalicia;

import com.mycompany.POJO.Autor;
import com.mycompany.POJO.Biblioteca;
import com.mycompany.POJO.Copia;
import com.mycompany.POJO.DVD;
import com.mycompany.POJO.Libro;
import com.mycompany.POJO.Obra;
import com.mycompany.POJO.Prestamo;
import com.mycompany.POJO.Socio;
import static com.mycompany.Sesiones.HBUtil.getSessionFactory;
import com.mycompany.Sesiones.Sesiones;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import org.hibernate.SessionFactory;

/**
 *
 * @author Estefania
 */
public class AñadirDatosRedBibliotecas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SessionFactory sessionFactory = getSessionFactory();

        Biblioteca b1 = new Biblioteca("BIBLIOTECA JUAN COMPAÑEL", "VIGO");
        Biblioteca b2 = new Biblioteca("BIBLIOTECA NEIRA VILAS", "VIGO");
        Biblioteca b3 = new Biblioteca("BIBLIOTECA PÚBLICA DE LUGO", "LUGO");
        Biblioteca b4 = new Biblioteca("BIBLIOTECA MUNICIPAL DE CELA", "BUEU");


        Autor a1 = new Autor("JANE", "AUSTEN", "INGLESA");
        Autor a2 = new Autor("MIGUEL", "DE CERVANTES SAAVEDRA", "ESPAÑOLA");
        Autor a3 = new Autor("CHARLES", "DICKENS", "INGLESA");
        Autor a4 = new Autor("FEDERICO", "GARCÍA LORCA", "ESPAÑOLA");
        Autor a5 = new Autor("GABRIEL", "GARCÍA MÁRQUEZ", "COLOMBIANA");
        Autor a6 = new Autor("JAMES", "JOYCE", "IRLANDESA");

        Libro l1 = new Libro("ORGULLO Y PREJUICIO", "DEBOLSILLO");
        l1.getAutores().add(a1);
        Libro l2 = new Libro("EMMA", "DEBOLSILLO");
        l2.getAutores().add(a1);
        Libro l3 = new Libro("DON QUIJOTE DE LA MANCHA", "CÁTEDRA");
        l3.getAutores().add(a2);
        Libro l4 = new Libro("GRANDES ESPERANZAS", "DEBOLSILLO");
        l4.getAutores().add(a3);
        Libro l5 = new Libro("ROMANCERO GITANO", "CÁTEDRA");
        l5.getAutores().add(a4);
        Libro l6 = new Libro("100 AÑOS DE SOLEDAD", "ANAGRAMA");
        l6.getAutores().add(a5);
        Libro l7 = new Libro("ULISES", "DEBOLSILLO");
        l7.getAutores().add(a6);
        Libro l8 = new Libro("LIBRO ESCRITO POR VARIOS AUTORES", "DEBOLSILLO");
        l8.getAutores().add(a5);
        l8.getAutores().add(a6);

        Obra d1 = new DVD("MATRIX", "HERMANAS WACHOWSKI");
        Obra d2 = new DVD("REGRESO AL FUTURO", "ROBERT ZEMECKIS");
        Obra d3 = new DVD("DOGVILLE", "LARS VON TRIER");
        Obra d4 = new DVD("EL GRAN DICTADOR", "CHARLES CHAPLIN");
        Obra d5 = new DVD("TOY STORY", "JOHN LASSETER");

        Copia c1 = new Copia(l1, b1, true);
        Copia c2 = new Copia(l1, b1, true);
        Copia c3 = new Copia(l2, b1, true);
        Copia c4 = new Copia(l3, b1, true);
        Copia c5 = new Copia(l3, b1, true);
        Copia c6 = new Copia(l4, b1, true);
        Copia c7 = new Copia(l6, b1, true);

        Copia c8 = new Copia(l1, b2, true);
        Copia c9 = new Copia(l7, b2, true);
        Copia c10 = new Copia(l2, b2, true);
        Copia c11 = new Copia(l8, b2, true);
        Copia c12 = new Copia(l3, b2, true);
        Copia c13 = new Copia(l4, b2, true);
        Copia c14 = new Copia(l6, b2, true);

        Copia c15 = new Copia(l8, b3, true);
        Copia c16 = new Copia(l7, b3, true);
        Copia c17 = new Copia(l2, b3, true);
        Copia c18 = new Copia(l8, b3, true);
        Copia c19 = new Copia(l6, b3, true);
        Copia c20 = new Copia(l5, b3, true);
        Copia c21 = new Copia(l6, b3, true);

        Copia c22 = new Copia(l1, b4, true);
        Copia c23 = new Copia(l3, b4, true);
        Copia c24 = new Copia(l6, b4, true);
        Copia c25 = new Copia(l8, b4, true);
        Copia c26 = new Copia(l8, b4, true);
        Copia c27 = new Copia(l5, b4, true);
        Copia c28 = new Copia(l2, b4, true);

        Copia c29 = new Copia(d1, b1, true);
        Copia c30 = new Copia(d4, b1, true);
        Copia c31 = new Copia(d5, b1, true);

        Copia c32 = new Copia(d2, b2, true);
        Copia c33 = new Copia(d3, b2, true);
        Copia c34 = new Copia(d3, b2, true);

        Copia c35 = new Copia(d1, b3, true);
        Copia c36 = new Copia(d2, b3, true);
        Copia c37 = new Copia(d5, b3, true);

        Copia c38 = new Copia(d3, b4, true);
        Copia c39 = new Copia(d4, b4, true);
        Copia c40 = new Copia(d5, b4, true);

        Socio s1 = new Socio("53191630J", "ESTEFANÍA PENIDE CASANOVA");
        Socio s2 = new Socio("41818958J", "LAURA GONZÁLEZ GARCÍA");
        Socio s3 = new Socio("10850852G", "PEDRO LÓPEZ PÉREZ");
        Socio s4 = new Socio("50132925D", "JUAN CALVO MARQUERIE");
        Socio s5 = new Socio("65361558C", "PATRICIA RAMOS TORRES");
        Socio s6 = new Socio("61378348L", "LUCÍA DOVAL PEDRIDO");


        LocalDate hoy = LocalDate.now();
        LocalDate devolucion = hoy.plusDays(15);
        LocalTime ahora = LocalTime.now();

        int dia = hoy.getDayOfMonth();
        int mes = hoy.getMonthValue();
        int year = hoy.getYear();

        int diaDev = devolucion.getDayOfMonth();
        int mesDev = devolucion.getMonthValue();
        int yearDev = devolucion.getYear();

        int h = ahora.getHour();
        int m = ahora.getMinute();
        int s = ahora.getSecond();

//        LocalDate a = LocalDate.of(2019, 2, 3);
//
//        long millis = System.currentTimeMillis();
//
//        Date date = new java.sql.Date(millis);
//
//        System.out.println(date);
//        int d = date.getDate();
//        int meeees = date.getMonth() + 1;
//        int yeeear = date.getYear() + 1900;
//
//        System.out.println(d);
//        System.out.println(meeees);
//        System.out.println(yeeear);
//
//        LocalDate b = LocalDate.of(2013, 3, 12);

//        Date fprestamo = Date.valueOf(hoy);
//        Date fprestamo = new Date(year - 1900, mes - 1, dia);
        Date fprestamo = Date.valueOf(LocalDate.of(year,mes,dia));
//        Date fprestamo = Date.valueOf(LocalDate.of(yeeear,meeees,d));
//        Date fprestamo = Date.valueOf(b);

//        Date fdevolucion = Date.valueOf(devolucion);
//        Date fdevolucion = new Date(yearDev - 1900, mesDev - 1, diaDev);
        Date fdevolucion = Date.valueOf(LocalDate.of(yearDev, mesDev, diaDev));
//        Time horaPrestamo =Time.valueOf(ahora);
        Time horaPrestamo = new Time(h, m, s);

        Prestamo p1 = new Prestamo(s1, c1, fprestamo, horaPrestamo);
        p1.setFechaDevolucion(fdevolucion);
        s1.setNumPrestamosActivos(1);
        c1.setDisponible(false);

        Prestamo p2 = new Prestamo(s1, c2, fprestamo, horaPrestamo);
        p2.setFechaDevolucion(fdevolucion);
        s1.setNumPrestamosActivos(2);
        c2.setDisponible(false);

        Prestamo p3 = new Prestamo(s2, c3, fprestamo, horaPrestamo);
        p3.setFechaDevolucion(fdevolucion);
        s2.setNumPrestamosActivos(1);
        c3.setDisponible(false);

        Prestamo p4 = new Prestamo(s3, c4, fprestamo, horaPrestamo);
        p4.setFechaDevolucion(fdevolucion);
        s3.setNumPrestamosActivos(1);
        c4.setDisponible(false);

        Sesiones.guardar(b1);
        Sesiones.guardar(b2);
        Sesiones.guardar(b3);
        Sesiones.guardar(b4);

        Sesiones.guardar(a1);
        Sesiones.guardar(a2);
        Sesiones.guardar(a3);
        Sesiones.guardar(a4);
        Sesiones.guardar(a5);
        Sesiones.guardar(a6);

        Sesiones.guardar(l1);
        Sesiones.guardar(l2);
        Sesiones.guardar(l3);
        Sesiones.guardar(l4);
        Sesiones.guardar(l5);
        Sesiones.guardar(l6);
        Sesiones.guardar(l7);
        Sesiones.guardar(l8);

        Sesiones.guardar(d1);
        Sesiones.guardar(d2);
        Sesiones.guardar(d3);
        Sesiones.guardar(d4);
        Sesiones.guardar(d5);

        Sesiones.guardar(c1);
        Sesiones.guardar(c2);
        Sesiones.guardar(c3);
        Sesiones.guardar(c4);
        Sesiones.guardar(c5);
        Sesiones.guardar(c6);
        Sesiones.guardar(c7);
        Sesiones.guardar(c8);
        Sesiones.guardar(c9);
        Sesiones.guardar(c10);
        Sesiones.guardar(c11);
        Sesiones.guardar(c12);
        Sesiones.guardar(c13);
        Sesiones.guardar(c14);
        Sesiones.guardar(c15);
        Sesiones.guardar(c16);
        Sesiones.guardar(c17);
        Sesiones.guardar(c18);
        Sesiones.guardar(c19);
        Sesiones.guardar(c20);
        Sesiones.guardar(c21);
        Sesiones.guardar(c22);
        Sesiones.guardar(c23);
        Sesiones.guardar(c24);
        Sesiones.guardar(c25);
        Sesiones.guardar(c26);
        Sesiones.guardar(c27);
        Sesiones.guardar(c28);
        Sesiones.guardar(c29);
        Sesiones.guardar(c30);
        Sesiones.guardar(c31);
        Sesiones.guardar(c32);
        Sesiones.guardar(c33);
        Sesiones.guardar(c34);
        Sesiones.guardar(c35);
        Sesiones.guardar(c36);
        Sesiones.guardar(c37);
        Sesiones.guardar(c38);
        Sesiones.guardar(c39);
        Sesiones.guardar(c40);

        Sesiones.guardar(s1);
        Sesiones.guardar(s2);
        Sesiones.guardar(s3);
        Sesiones.guardar(s4);
        Sesiones.guardar(s5);
        Sesiones.guardar(s6);

        Sesiones.guardar(p1);
        Sesiones.guardar(p2);
        Sesiones.guardar(p3);
        Sesiones.guardar(p4);

        sessionFactory.close();
    }

}
