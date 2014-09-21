package reivax.norac.addressbook.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Helper class for Hibernate DB connection management.
 * 
 * @author Xavier
 *
 */
public class HibernateUtil {
	 
    private static final SessionFactory sessionFactory = buildSessionFactory();
 
    /**
     * Initialises the Session, based on the hibernate.cfg.xml file, containing DB connection properties.
     * 
     * @return the SessionFactory
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure("/main/resources/hibernate.cfg.xml").buildSessionFactory();
 
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /**
     * Helper method to close the session.
     */
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }
 
}
