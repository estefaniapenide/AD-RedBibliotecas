/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.company.CRUD;

import com.mycompany.POJO.Autor;
import com.mycompany.POJO.DVD;
import com.mycompany.POJO.Libro;
import com.mycompany.POJO.Obra;
import com.mycompany.POJO.Prestamo;
import static com.mycompany.Sesiones.HBUtil.getSessionFactory;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Estefania
 */
public class AutorCRUD {
    
    public static Autor obtenerAutor(Autor autor){
        
       Autor a= null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(Autor.class);
            criteria.add(Restrictions.eq("nombre", autor.getNombre()));
            criteria.add(Restrictions.eq("apellidos", autor.getApellidos()));
            List results = criteria.list();
            //Si no existe se captura la expeción y se devuelve el libro como null
            a = (Autor) results.get(0);

        } catch (IndexOutOfBoundsException e) {
        } finally {
            
            session.close();

        }
        
        return a;
    
    }

    
}
