package claseMain;

import modelos.Cancion;
import modelos.CancionSinAnotaciones;
import modelos.PruebaModHiber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import util.HibernateUtil;

public class MainClase {
    public static void main(String[] args) {
        System.out.println("Prueba de Hibernate");


        Cancion cancion = new Cancion();
        cancion.setNombre("Prueba2");
        cancion.setDuracion("13:33");
        cancion.setDisco("1");
        cancion.setGenero("1");
        cancion.setInterprete("1");

        Cancion cancion2 = new Cancion();


        PruebaModHiber prueba = new PruebaModHiber();
        prueba.setAtributo("Coso");

        try {
/*
            //para clase sin anotaciones, cambia el sessionFactory
            //Get Session
            Session session = HibernateUtil.getSessionFactory().openSession();
            //start transaction
            session.beginTransaction();
            //Save the Model object
            //session.persist(cancion);
            session.persist(prueba);
            //Commit transaction
            session.getTransaction().commit();
            //System.out.println("Cancion ID="+cancion.getId());

 */
            //probamos de otra forma


            //1- crea conexion
            // Create Session Factory Object  – using configuration object
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            //Create Session object from session factory object
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //2- uso la sesion para persistir (create)
            //session.persist(cancion);

            //otra forma, solo para hibernate (create o update)
            //cancion.setId(4);
            //session.saveOrUpdate(cancion);

            //opcion merge (create )
            //session.merge(cancion);

            // update
            //cancion.setId(5);
            //session.merge(cancion);

            //delete
            cancion.setId(5);
            session.delete(cancion);

            //commit para ejecutar la query
            session.getTransaction().commit();

            //read
            cancion2 = session.get(Cancion.class, 4);

            System.out.println("-------\nCancion:");
            System.out.println("ID: " + cancion2.getId());
            System.out.println("NOMBRE: " + cancion2.getNombre());


            /*
             If we don’t have any special requirements, we should stick to the persist and
            merge methods because they’re standardized and will conform to the JPA specification.
             They’re also portable in case we decide to switch to another persistence provider;
            however, they may sometimes seem not as useful as the “original” Hibernate methods,
            save, update, and saveOrUpdate.

             */

            //pido id para comprobar persistencia
            System.out.println("Cancion ID: " + cancion.getId());

            //3- cierro sesion
            session.close();


        }
        catch (Exception ex) {
            System.out.println("Error!");
            //System.out.println(ex.getMessage());
            System.out.println(ex.toString());
        }
        finally {
            //terminate session factory, otherwise program won't end
            //HibernateUtil.getSessionFactory().close();
        }
    }
}
