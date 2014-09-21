package reivax.norac.addressbook.model;

import java.util.List;

import org.hibernate.Session;

import reivax.norac.addressbook.util.HibernateUtil;

/**
 * Database access and interaction.
 * 
 * @author Xavier
 *
 */
public class DBConnection {
	
	/**
	 * Adds an Entry into the DB.
	 * 
	 * @param e the Entry to be added
	 */
	public void addEntry(Entry e){
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		session.save(e);

		session.getTransaction().commit();

		HibernateUtil.shutdown();
	}
	
	/**
	 * Removes an Entry from the DB.
	 * 
	 * @param e the Entry to be removed
	 */
	public void removeEntry(Entry e){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.delete(e);

		session.getTransaction().commit();

		HibernateUtil.shutdown();
	}
	
	/**
	 * Gets all content from DB.
	 * 
	 * @return the list of Entry entities
	 */
	public static List<Entry> getBook(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Entry> book = session.getNamedQuery("Entry.findAll").list();

		HibernateUtil.shutdown();
		return book;
	}
}
