/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Cadenas;

/**
 *
 * @author Estefania
 */
public class Cadenas {

    public static void menuPrincipal() {
        System.out.println("\n**********************  RED DE BIBLIOTECAS DE GALICIA  ************************************\n"
                + "\n1.-ALTAS"
                + "\n2.-BAJAS"
                + "\n3.-MODIFICACIONES"
                + "\n4.-LISTADOS"
                + "\n\n5.-FIN");
    }

    public static void mensajeDefault() {
        System.out.println("\nNO HA INTRODUCIDO NINGUNA DE LAS OPCIONES");
    }

    public static void fin() {
        System.out.println("\nPROGRAMA FINALIZADO");
    }

    public static void menuAltas() {
        System.out.println("\n**********************  ALTAS  ************************************\n"
                + "\n1.-BIBLIOTECA"
                + "\n2.-OBRA"
                + "\n3.-AUTOR"
                + "\n4.-COPIA"
                + "\n5.-SOCIO"
                + "\n6.-PRÉSTAMO"
                + "\n\n0.-VOLVER AL MENÚ ANTERIOR");
    }

    public static void menuBajas() {
        System.out.println("\n**********************  BAJAS  ************************************\n"
                + "\n1.-BIBLIOTECA"
                + "\n2.-OBRA"
                + "\n3.-COPIA"
                + "\n4.-SOCIO"
                + "\n\n0.-VOLVER AL MENÚ ANTERIOR");
    }

    public static void menuModificaciones() {
        System.out.println("\n**********************  MODIFICACIONES  ************************************\n"
                + "\n1.-PRÉSTAMO - AÑADIR DEVOLUCIÓN"
                + "\n2.-SOCIO - CAMBIAR NOMBRE"
                + "\n3.-SOCIO - QUITAR/AÑADIR MULTA"
                + "\n\n0.-VOLVER AL MENÚ ANTERIOR");
    }

    public static void menuListados() {
        System.out.println("\n**********************  COSULTAS  ************************************\n"
                + "\n1.-MOSTRAR TODAS LAS BIBLIOTECAS"
                + "\n2.-MOSTRAR TODOS LOS SOCIOS"
                + "\n3.-MOSTRAR TODOS LOS LIBROS"
                + "\n4.-MOSTRAR TODOS LOS DVDs"
                + "\n5.-MOSTRAR TODOS LOS PRÉSTAMOS ACTIVOS"
                + "\n\n6.-VER TODAS LAS COPIAS DE UNA BIBLIOTECA"
                + "\n7.-VER TODOS LOS LIBROS DE UN AUTOR"
                + "\n8.-BUSCAR PRESTAMOS DE UN SOCIO EN DOS FECHAS"
                + "\n\n0.-VOLVER AL MENÚ ANTERIOR");
    }

    public static void menuObras() {
        System.out.println("\n1.-LIBRO"
                + "\n2.-DVD"
                + "\n\n0.-VOLVER AL MENÚ ANTERIOR");
    }

    public static void menuAnterior() {
        System.out.println("\nVOLVIENDO AL MENÚ ANTERIOR...");
    }

    public static void biblioteca() {
        System.out.println("\n\tBIBLIOTECA");
    }

    public static void nombre() {
        System.out.println("NOMBRE:");
    }

    public static void direccion() {
        System.out.println("DIRECCIÓN:");
    }

    public static void bibliotecaYaExiste() {
        System.out.println("\nLA BIBLIOTECA YA EXISTE");
    }

    public static void altaObra() {
        System.out.println("\n\tALTA OBRA");
    }

    public static void bajaObra() {
        System.out.println("\n\tBAJA OBRA");
    }

    public static void bibliotecaNoExiste() {
        System.out.println("\nLA BIBLIOTECA NO EXISTE");
    }

    public static void bibliotecaBorrada() {
        System.out.println("\nLA BIBLIOTECA HA SIDO BORRADA");
    }

    public static void libro() {
        System.out.println("\n\tLIBRO");
    }

    public static void titulo() {
        System.out.println("TÍTULO:");
    }

    public static void autor() {
        System.out.println("\n\tAUTOR");
    }

    public static void editorial() {
        System.out.println("EDITORIAL:");
    }

    public static void libroAdded() {
        System.out.println("\nLIBRO AÑADIDO");
    }

    public static void libroYaExiste() {
        System.out.println("\nEL LIBRO YA EXISTE");
    }

    public static void DVD() {
        System.out.println("\n\tDVD");
    }

    public static void director() {
        System.out.println("DIRECTOR:");
    }

    public static void DVDAdded() {
        System.out.println("\nDVD AÑADIDO");
    }

    public static void DVDYaExiste() {
        System.out.println("\nEL LIBRO YA EXISTE");
    }

    public static void libroBorrado() {
        System.out.println("\nEL LIBRO HA SIDO BORRADA");
    }

    public static void DVDBorrado() {
        System.out.println("\nEL DVD HA SIDO BORRADA");
    }

    public static void libroNoExiste() {
        System.out.println("\nEL LIBRO NO EXISTE");
    }

    public static void DVDNoExiste() {
        System.out.println("\nEL DVD NO EXISTE");
    }

    public static void altaCopia() {
        System.out.println("\n\tALTA COPIA");
    }

    public static void copia() {
        System.out.println("\n\tCOPIA");
    }

    public static void bajaCopia() {
        System.out.println("\n\tBAJA COPIA");
    }

    public static void copiaAdded() {
        System.out.println("\nCOPIA AÑADIDA");
    }

    public static void idCopia() {
        System.out.println("ID COPIA:");
    }

    public static void copiaNoExiste() {
        System.out.println("\nLA COPIA NO EXISTE");
    }

    public static void copiaBorrada() {
        System.out.println("\nLA COPIA HA SIDO BORRADA");
    }

    public static void socio() {
        System.out.println("\n\tSOCIO");
    }

    public static void dni() {
        System.out.println("DNI:");
    }

    public static void nombreCompleto() {
        System.out.println("\nNOMBRE COMPLETO:");
    }

    public static void socioYaExiste() {
        System.out.println("\nEL SOCIO YA EXISTE");
    }

    public static void socioAdded() {
        System.out.println("\nSOCIO AÑADIDO");
    }

    public static void socioNoExiste() {
        System.out.println("\nEL SOCIO NO EXISTE");
    }

    public static void socioBorrado() {
        System.out.println("\nEL SOCIO HA SIDO BORRADO");
    }

    public static void confirmarBorrarSocio() {
        System.out.println("\nCONFIRMA QUE DESEA ELIMINAR EL SOCIO"
                + "\n1.-SÍ"
                + "\n2.-NO");
    }

    public static void prestamo() {
        System.out.println("\n\tPRÉSTAMO");
    }

    public static void copiaNoDisponible() {
        System.out.println("\nLA COPIA NO ESTÁ DISPONIBLE");
    }

    public static void prestamoAdded() {
        System.out.println("\nPRESTAMO AÑADIDO");
    }

    public static void prestamosActivos() {
        System.out.println("\n\tPRESTAMOS ACTIVOS");
    }

    public static void addevolucion() {
        System.out.println("\n\tAÑADIR DEVOLUCIÓN");
    }

    public static void fechaPrestamo() {
        System.out.println("FECHA PRÉSTAMO (YYYY-MM-DD):");
    }

    public static void horaPrestamo() {
        System.out.println("HORA PRÉSTAMO (HH:MM:SS):");
    }

    public static void prestamoNoExiste() {
        System.out.println("\nEL PRÉSTAMO NO EXISTE");
    }

    public static void nuevoNombre() {
        System.out.println("\nNUEVO NOMBRE COMPLETO:");
    }

    public static void nombreModificado() {
        System.out.println("\nNOMBRE MODIFICADO");
    }

    public static void menuMulta(String opcion) {
        System.out.println("\n" + opcion + " MULTA AL SOCIO"
                + "\n1.-SÍ"
                + "\n2.-NO");
    }

    public static void multaEliminada() {
        System.out.println("\nMULTA ELIMINADA");
    }

    public static void multaAdded() {
        System.out.println("\nMULTA AÑADIDA");
    }

    public static void fechaMulta() {
        System.out.println("\nSANCIÓN HASTA (YYYY-MM-DD):");
    }

    public static void todasBibliotecas() {
        System.out.println("\n\tTODOS LAS BIBLIOTECAS");
    }

    public static void todosSocios() {
        System.out.println("\n\tTODOS LOS SOCIOS");
    }

    public static void todosLibros() {
        System.out.println("\n\tTODOS LOS LIBROS");
    }

    public static void todosDVDs() {
        System.out.println("\n\tTODOS LOS DVDs");
    }

    public static void apellidos() {
        System.out.println("APELLIDOS:");
    }

    public static void nacionalidad() {
          System.out.println("NACIONALIDAD:");
    }

    public static void autorYaExiste() {
        System.out.println("\nEL AUTOR YA EXISTE");
    }

    public static void autorAdded() {
         System.out.println("\nAUTOR AÑADIDO");
    }

    public static void menuAutores() {
       System.out.println("\nAÑADIR AUTOR"
                + "\n1.-SÍ"
                + "\n2.-NO");
    }

    public static void autorNoExiste() {
        System.out.println("\nEL AUROR NO EXISTE\nDEBE DARLO DE ALTA PRIMERO");
    }

}
