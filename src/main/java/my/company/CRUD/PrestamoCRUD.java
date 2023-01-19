/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.company.CRUD;

import com.mycompany.ControlData.LocalDateConverter;
import com.mycompany.POJO.Copia;
import com.mycompany.POJO.DVD;
import com.mycompany.POJO.Libro;
import com.mycompany.POJO.Obra;
import com.mycompany.POJO.Prestamo;
import com.mycompany.POJO.Socio;
import static com.mycompany.Sesiones.HBUtil.getSessionFactory;
import com.mycompany.Sesiones.Sesiones;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Estefania
 */
public class PrestamoCRUD {

    public static File log = new File("LogDevoluciones.txt");//Registro de prestamos devueltos

    public static final int DIAS_PRESTAMO = 15;
    public static final int DIAS_SANCION = 15;

    public static List<Prestamo> obtenerPrestamos() {

        List<Prestamo> prestamos = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        String query = "FROM Prestamo";
        prestamos = session.createQuery(query).list();
        session.close();

        return prestamos;

    }

    public static Prestamo obtenerPrestamo(Prestamo prestamo) {

        Prestamo p = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        p = (Prestamo) session.get(Prestamo.class, prestamo);
        session.close();

        return p;
    }

    public static Prestamo obtenerPrestamoActivo(int idCopia) {

        Prestamo prestamo = null;
//        List<Prestamo> prestamos = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        String query = "FROM Prestamo WHERE IdCopia=" + idCopia + "";
        prestamo = (Prestamo) session.createQuery(query).uniqueResult();
//        prestamo = prestamos.get(0);
        session.close();

        return prestamo;
    }

    public static void nuevoPrestamo(Socio socio, Copia copia) {

        LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        LocalDate devolucion = hoy.plusDays(DIAS_PRESTAMO);
        
        int dia = hoy.getDayOfMonth();
        int mes = hoy.getMonthValue();
        int year = hoy.getYear();

        int diaDev = devolucion.getDayOfMonth();
        int mesDev = devolucion.getMonthValue();
        int yearDev = devolucion.getYear();

        int h = ahora.getHour();
        int m = ahora.getMinute();
        int s = ahora.getSecond();

//        Date fechaprestamo = new Date(year - 1900, mes - 1, dia);
//        Date fechadevolucion = new Date(yearDev - 1900, mesDev - 1, diaDev);

        Date fechaprestamo = Date.valueOf(LocalDate.of(year,mes,dia));
        Date fechadevolucion = Date.valueOf(LocalDate.of(yearDev, mesDev, diaDev));
        Time horaPrestamo = new Time(h, m, s);

        Prestamo prestamo = new Prestamo(socio, copia, fechaprestamo, horaPrestamo);
        prestamo.setFechaDevolucion(fechadevolucion);
        Sesiones.guardar(prestamo);
       
    }

    public static void addDevolucion(Prestamo prestamo) {

        LocalDate hoy = LocalDate.now();
        int dia = hoy.getDayOfMonth();
        int mes = hoy.getMonthValue();
        int year = hoy.getYear();

//        Date fechaDevuelto = Date.valueOf(hoy);
//        Date fechaDevuelto = new Date(year - 1900, mes - 1, dia);
        Date fechaDevuelto = Date.valueOf(LocalDate.of(year, mes, dia));
        prestamo.setFechaDevuelto(fechaDevuelto);

        prestamo.getCopia().setDisponible(true);
        int prestamosSocio = prestamo.getSocio().getNumPrestamosActivos() - 1;
        prestamo.getSocio().setNumPrestamosActivos(prestamosSocio);

        Sesiones.actualizar(prestamo.getCopia());
        Sesiones.actualizar(prestamo.getSocio());
        Sesiones.actualizar(prestamo);

        addDevolucionALog(prestamo);
        addMulta(prestamo);

    }

    private static void addDevolucionALog(Prestamo prestamo) {
        try {
            String str = prestamo.toString();
            BufferedWriter writer = new BufferedWriter(new FileWriter(log, true));
            writer.append('\n');
            writer.append(str);

            writer.close();
        } catch (IOException e) {
        }
    }

    public static void addMulta(Prestamo prestamo) {

        LocalDate today = LocalDate.now();
        LocalDate multa = today.plusDays(DIAS_SANCION);

        int dia = today.getDayOfMonth();
        int mes = today.getMonthValue();
        int year = today.getYear();

        int diaMulta = multa.getDayOfMonth();
        int mesMulta = multa.getMonthValue();
        int yearMulta = multa.getYear();

        Date hoy = Date.valueOf(LocalDate.of(year, mes, dia));
        Date fechaMulta = Date.valueOf(LocalDate.of(yearMulta, mesMulta, diaMulta));//Suma uno porque se guarda en la base de datos con un día de menos

        Date fechaDevuelto = prestamo.getFechaDevuelto();
        Date fechaDevolucion = prestamo.getFechaDevuelto();
        try {
            if (Objects.isNull(fechaDevuelto) && hoy.compareTo(fechaDevolucion) > 0) {//Si no se ha devuelto y la fecha de hoy es mayor que la fecha de devolución

                prestamo.getSocio().setMulta(true);
                prestamo.getSocio().setFechaMulta(fechaMulta);

                Sesiones.actualizar(prestamo.getSocio());

            } else if (fechaDevuelto.compareTo(fechaDevolucion) > 0) {//Si se ha devuelto pero la fecha en la que se devuelve es mayor que la fecha de devolución

                prestamo.getSocio().setMulta(true);
                prestamo.getSocio().setFechaMulta(fechaMulta);

                Sesiones.actualizar(prestamo.getSocio());
            }

        } catch (NullPointerException e) {
            //No hacemos nada si pilla la excepción. Sólo significa que no se ha devuelto todavía y que está dentro de fecha
        } finally {
        }
    }

    public static List<Prestamo> obtenerPrestamosDeUnSocioDeDosFechas(Socio socio, Date f1, Date f2) {

        List<Prestamo> prestamos = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        String query = "FROM Prestamo WHERE IdSocio=" + socio.getId() + " AND (fechaPrestamo = '" + f1 + "' OR fechaPrestamo = '" + f2 + "')";
//        String query = "FROM Prestamo WHERE IdSocio=" + socio.getId() + " AND fechaPrestamo BETWEEN '" + f1 + "' AND '" + f2+"'" ;
        prestamos = session.createQuery(query).list();
        session.close();

        return prestamos;
    }

}
