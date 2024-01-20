package com.mycompany.hibernatepolo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

public class Ejemplo1 {
 
    public static void main(String[] args) {
    
        
        Ejemplo1 es=new Ejemplo1();
        
        es.ejemplo2();
    }

    public void ejemplo2() {
        createAndStoreEvent("El Event", new Date());
      //  listEvents();
        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Factura theEvent = new Factura();
       // theEvent.setNum_factura();
        theEvent.setDescripcion_factura("factura 2");
        session.save(theEvent);
        session.getTransaction().commit();
      //  log.info("Insertado: "+theEvent);
    }
}  
  /*  private List<Event> listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Event> result = (List<Event>)session.createQuery("from Event").list();
        session.getTransaction().commit();
        for (Event evento : result) {
            log.info("Leido: "+evento);}return result;
    
    }
*/