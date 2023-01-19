/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.company.CRUD;

import com.mycompany.POJO.Biblioteca;
import com.mycompany.POJO.Copia;
import com.mycompany.POJO.Socio;
import static com.mycompany.Sesiones.HBUtil.getSessionFactory;
import com.mycompany.Sesiones.Sesiones;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Estefania
 */
public class SocioCRUD {

    public static Socio obtenerSocio(String dni) {

        Socio socio = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        String query = "FROM Socio WHERE dni='" + dni + "'";
        socio = (Socio) session.createQuery(query).uniqueResult();
        session.close();

        return socio;

    }

    public static List<Socio> obtenerSocios() {

        List<Socio> socios = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        String query = "FROM Socio";
        socios = session.createQuery(query).list();
        session.close();

        return socios;

    }

    public static List<Socio> listaSocios() {

        List<Socio> socios = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        socios = session.createNamedQuery("socios").list();
        session.close();

        return socios;
    }

}
