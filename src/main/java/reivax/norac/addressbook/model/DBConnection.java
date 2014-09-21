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
	
	public void addEntry(Entry e){
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		session.save(e);

		session.getTransaction().commit();

		HibernateUtil.shutdown();
	}
	
	public void removeEntry(Entry e){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.delete(e);

		session.getTransaction().commit();

		HibernateUtil.shutdown();
	}
	
	public static List<Entry> getBook(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Entry> book = session.getNamedQuery("Entry.findAll").list();

		HibernateUtil.shutdown();
		return book;
	}
}
