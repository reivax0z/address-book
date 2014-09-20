package reivax.norac.addressbook.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Database access and interaction.
 * 
 * @author Xavier
 *
 */
public class DBConnection {
	
	private static Connection con = null;
	
	public DBConnection(){
//		try {
//			con = getConnection();
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	private static Connection getConnection() throws URISyntaxException, SQLException {
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	public void addEntry(Entry e){
		//TODO
	}
	
	public void removeEntry(Entry e){
		//TODO
	}
	
	public static List<Entry> getBook(){
		List<Entry> book = new ArrayList<Entry>();
		
		Entry e = new Entry();
		e.setId(1);
		e.setName("Bob");
		e.setPhone("0000000000");
		book.add(e);
		
		Entry e2 = new Entry();
		e2.setId(2);
		e2.setName("Luc");
		e2.setPhone("111111111");
		book.add(e2);
		
		Entry e3 = new Entry();
		e3.setId(3);
		e3.setName("Roxy");
		e3.setPhone("222222222");
		book.add(e3);
		
		Entry e4 = new Entry();
		e4.setId(4);
		e4.setName("Boby");
		e4.setPhone("333333333");
		book.add(e4);
		
		return book;
	}
}
