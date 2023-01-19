/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.redebibliotecasgalicia;

import com.mycompany.Cadenas.Cadenas;
import com.mycompany.ControlData.ControlData;
import com.mycompany.Operaciones.Altas;
import com.mycompany.Operaciones.Bajas;
import com.mycompany.Operaciones.Listados;
import com.mycompany.Operaciones.Modificaciones;
import com.mycompany.POJO.Prestamo;
import static com.mycompany.Sesiones.HBUtil.getSessionFactory;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import my.company.CRUD.PrestamoCRUD;
import org.hibernate.SessionFactory;

/**
 *
 * @author Estefania
 */
public class RedeBibliotecasGalicia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        LocalDate h = LocalDate.now();
        int i = h.getDayOfMonth();
         System.out.println(h);
          System.out.println(i);
        
        //Para guardar el historial de devoluciones
        if (!PrestamoCRUD.log.exists()) {
            try {
                PrestamoCRUD.log.createNewFile();
            } catch (IOException E) {
            }
        }

        Scanner input = new Scanner(System.in);

        SessionFactory sessionFactory = getSessionFactory();

        //Actualizando las multas de los prestamos cada vez que se ejecute la aplicacoón
        List<Prestamo> prestamos = PrestamoCRUD.obtenerPrestamos();
        for (Prestamo prestamo : prestamos) {
            PrestamoCRUD.addMulta(prestamo);
        }

        byte op = 5;
        do {
            Cadenas.menuPrincipal();
            op = ControlData.leerByte(input);

            switch (op) {
                case 1:
                    Altas.menuAltas(input);
                    break;
                case 2:
                    Bajas.menuBajas(input);
                    break;
                case 3:
                    Modificaciones.menuModificaciones(input);
                    break;
                case 4:
                    Listados.menuListados(input);
                    break;
                case 5:
                    Cadenas.fin();
                    break;
                default:
                    Cadenas.mensajeDefault();
                    break;
            }
        } while (op != 5);

        sessionFactory.close();
        input.close();

    }

}
