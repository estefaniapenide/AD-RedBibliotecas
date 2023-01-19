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
import static my.company.CRUD.SocioCRUD.obtenerSocios;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Estefania
 */
public class BibliotecaCRUD {

    public static Biblioteca obtenerBiblioteca(String nombreBiblioteca) {

        Biblioteca biblioteca = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(Biblioteca.class);
            //Busco por el nombre porque aunque no es la clave primaria, está definida como unique
            criteria.add(Restrictions.like("nombre", nombreBiblioteca));
            List results = criteria.list();
            //Si no existe se captura la expeción y se devuelve la biblioteca como null
            biblioteca = (Biblioteca) results.get(0);

        } catch (IndexOutOfBoundsException e) {
        } finally {

            session.close();
        }

        return biblioteca;
    }
    
     public static List<Biblioteca> obtenerBibliotecas() {

        List<Biblioteca> bibliotecas = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        String query = "FROM Biblioteca";
        bibliotecas = session.createQuery(query).list();
        session.close();

        return bibliotecas;

    }
     
}
