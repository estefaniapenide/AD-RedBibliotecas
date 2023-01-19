/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.company.CRUD;

import com.mycompany.POJO.Biblioteca;
import com.mycompany.POJO.Libro;
import com.mycompany.POJO.Obra;
import static com.mycompany.Sesiones.HBUtil.getSessionFactory;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Estefania
 */
public class LibroCRUD {
    
        public static Libro obtenerLibro(String titulo, String editorial) {

        Libro obra = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(Obra.class);
            //Como no usé ISBN, aunque los campos no formen una clave primaria, voy a usar el criterio de que el libro es el mismo si
            //sus atributos de título y  editorial son iguales
            criteria.add(Restrictions.like("titulo", titulo));
            criteria.add(Restrictions.like("editorial", editorial));
            List results = criteria.list();
            //Si no existe se captura la expeción y se devuelve el libro como null
            obra = (Libro) results.get(0);

        } catch (IndexOutOfBoundsException e) {
        } finally {
            
            session.close();

        }
        
        return obra;
    }

    
        public static List<Libro> obtenerLibros() {

        List<Libro> libros = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        String query = "FROM Libro";
        libros = session.createQuery(query).list();
        session.close();

        return libros;

    }

        

}
