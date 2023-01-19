/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.company.CRUD;

import com.mycompany.POJO.Biblioteca;
import com.mycompany.POJO.Copia;
import com.mycompany.POJO.DVD;
import com.mycompany.POJO.Libro;
import com.mycompany.POJO.Obra;
import static com.mycompany.Sesiones.HBUtil.getSessionFactory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Estefania
 */
public class CopiaCRUD {

    public static Copia obtenerCopia(int idCopia) {

        Copia copia = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        copia = (Copia) session.get(Copia.class, idCopia);
        session.close();

        return copia;

    }

    public static List<Copia> obtenerCopias(Obra obra) {

        List<Copia> copias = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        String query = "FROM Copia WHERE IdObra=" + obra.getId();
        copias = session.createQuery(query).list();
        session.close();

        return copias;

    }

    public static List<Copia> obtenerCopias(Biblioteca biblioteca) {

        List<Copia> copias = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        String query = "FROM Copia WHERE IdBiblioteca=" + biblioteca.getId();
        copias = session.createQuery(query).list();
        session.close();

        return copias;

    }



    public static boolean hayCopiasPrestadas(Obra obra) {
        boolean copiasPrestadas = false;
        List<Copia> copias = obtenerCopias(obra);
        for (Copia copia : copias) {
            if (!copia.isDisponible()) {
                copiasPrestadas = true;
            }
        }
        return copiasPrestadas;
    }

    public static boolean hayCopiasPrestadas(Biblioteca biblioteca) {
        boolean copiasPrestadas = false;
        List<Copia> copias = obtenerCopias(biblioteca);
        for (Copia copia : copias) {
            if (!copia.isDisponible()) {
                copiasPrestadas = true;
            }
        }
        return copiasPrestadas;
    }
    

}
