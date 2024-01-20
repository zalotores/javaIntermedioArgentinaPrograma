package com.mycompany.hibernateanotaciones2;

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
        createAndStoreEvent("El Event");
      //  listEvents();
        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStoreEvent(String title) {
      //  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      //  session.beginTransaction();
        Factura theEvent = new Factura();
       // theEvent.setNum_factura();
        theEvent.setDescripcion_factura("factura 2");
        theEvent.setMonto_total(3456);
// session.save(theEvent);
        //session.getTransaction().commit();
      //  log.info("Insertado: "+theEvent);
  
    listCliente();
    }
 
    private void listEvents() {
        
        //estas dos lineas ya están en el otro método
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //estas dos lineas ya están en el otro método
        
        //en el from ponemos la clase Factura
        List<Factura> result = (List<Factura>)session.createQuery("from Factura").list();
        session.getTransaction().commit();
        for (Factura evento : result) {
            System.out.println(evento.getDescripcion_factura());
    
    }  } 
        
       private void listCliente() {
        
        //estas dos lineas ya están en el otro método
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
       Cliente miCliente=new Cliente();
       
       miCliente.setCod_cliente(3);
       miCliente.setNombre_cliente("111111");
       
     /*  Cliente miCliente1=new Cliente();
       
       miCliente1.setCod_cliente(2);
       miCliente1.setNombre_cliente("22222");
       */
       
       
     //   Cliente miCliente1=new Cliente();
      // miCliente1.setCod_cliente(5);
      // miCliente1.setNombre_cliente("ernesto");

        Factura miFactura = new Factura();
       // theEvent.setNum_factura();
        miFactura.setDescripcion_factura("factura 5");
        miFactura.setMonto_total(3456);
       
        //List<Cliente> misClientes= new ArrayList<Cliente>();
       // misClientes.add(miCliente);
       // misClientes.add(miCliente1);
        
        miFactura.setCli(miCliente);
       
        session.save(miFactura);
        session.getTransaction().commit();
        session.close();
     /*   List<Factura> result = (List<Factura>)session.createQuery("from Factura").list();
        session.getTransaction().commit();
        for (Factura evento : result) {
            System.out.println(evento.getDescripcion_factura());
            
}
       */
       
       
}}