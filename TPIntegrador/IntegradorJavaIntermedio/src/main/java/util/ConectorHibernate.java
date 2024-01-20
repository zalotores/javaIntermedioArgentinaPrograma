package util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ConectorHibernate {

    public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public static Session session = sessionFactory.openSession();

    public ConectorHibernate() {
    }

    //lee desde la base una clase y devuelve los valores de primary key (read)
    public Object read(Object objeto, int id) {
        return session.get(objeto.getClass(), id);
    }

    //devuelve una lista con los resultados de una query en sql de hibernate
    public List<Object> leerLista (String hql) {
        Query query = session.createQuery(hql);
        return query.list();
    }

    //create
    public boolean create (Object objeto) {
        try {
            session.persist(objeto);
            session.getTransaction().commit();
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    //update
    public boolean update (Object objeto) {
        try {
            session.merge(objeto);
            session.getTransaction().commit();
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    //delete
    public boolean delete (Object objeto) {
        try {
            session.delete(objeto);
            session.getTransaction().commit();
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    //cerrar conexion
    public void desconectar() {
        session.close();
    }

}
