package util;

import modelos.Cancion;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    //Crea las SessionFactory para los distintos tipos de conexion

    //XML based configuration
    private static SessionFactory sessionSinAnotacionesFactory;

    //Annotation based configuration
    private static SessionFactory sessionFactory;

    //Property based configuration
    private static SessionFactory sessionJavaConfigFactory;

    //metodos

    private static SessionFactory buildSessionSinAnotacionesFactory() {
        try {
            // Crea la SessionFactory de hibernateSinAnotaciones.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernateSinAnotaciones.cfg.xml");
            System.out.println("Hibernate Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml (con anotaciones)
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            System.out.println("Hibernate Annotation Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate Annotation serviceRegistry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
/*
    private static SessionFactory buildSessionJavaConfigFactory() {
        try {
            Configuration configuration = new Configuration();

            //Create Properties, can be read from property files too
            Properties props = new Properties();
            props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            props.put("hibernate.connection.url", "jdbc:mysql://localhost/argentina_programa");
            props.put("hibernate.connection.username", "root");
            props.put("hibernate.connection.password", "Exa76419");
            props.put("hibernate.current_session_context_class", "thread");
            props.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialec");

            configuration.setProperties(props);

            //we can set mapping file or class with annotation
            //addClass(Employee1.class) will look for resource
            // com/journaldev/hibernate/model/Employee1.hbm.xml (not good)
            configuration.addAnnotatedClass(modelos.Cancion.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate Java Config serviceRegistry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
*/
    /*
    Creating SessionFactory for XML based configuration is same whether mapping is XML based
    or annotation based. For properties based, we need to set the properties in Configuration
    object and add annotation classes before creating the SessionFactory. Overall creating
    SessionFactory includes following steps:

    -Creating Configuration object and configure it
    -Creating ServiceRegistry object and apply configuration settings.
    -Use configuration.buildSessionFactory() by passing ServiceRegistry object as argument to
     get the SessionFactory object.

     */

    //getters


    public static SessionFactory getSessionSinAnotacionesFactory() {
        if(sessionSinAnotacionesFactory == null)
            sessionSinAnotacionesFactory = buildSessionFactory();
        return sessionSinAnotacionesFactory;
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
/*
    public static SessionFactory getSessionJavaConfigFactory() {
        if(sessionJavaConfigFactory == null)
            sessionJavaConfigFactory = buildSessionJavaConfigFactory();
        return sessionJavaConfigFactory;
    }*/
}
