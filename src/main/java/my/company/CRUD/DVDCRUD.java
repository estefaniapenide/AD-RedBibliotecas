/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.company.CRUD;

import com.mycompany.POJO.DVD;
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
public class DVDCRUD {
    
    public static Obra obtenerDVD(String titulo, String director) {

        Obra obra = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(Obra.class);//Funciona porque hace joins con las otras tablas!!!
            //Usando el mismo crieterio que en Libro para probar el criteria
            criteria.add(Restrictions.like("titulo", titulo));
            criteria.add(Restrictions.like("director", director));
            List results = criteria.list();
            //Si no existe se captura la expeción y se devuelve el libro como null
            obra = (DVD) results.get(0);

        } catch (IndexOutOfBoundsException e) {
        } finally {
            
            session.close();

        }
        
        return obra;
    }
    
          public static List<DVD> obtenerDVDs() {

        List<DVD> DVDs = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        String query = "FROM DVD";
        DVDs = session.createQuery(query).list();
        session.close();

        return DVDs;

    }
    
}
