package reivax.norac.addressbook.util;


import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
    public static Connection getConnection() throws URISyntaxException, SQLException {
    	URI dbUri = new URI(System.getenv("DATABASE_URL"));

    	String username = dbUri.getUserInfo().split(":")[0];
    	String password = dbUri.getUserInfo().split(":")[1];
    	String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

    	return DriverManager.getConnection(dbUrl, username, password);
    }
 
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }
 
}
