package reivax.norac.addressbook.model;

import java.util.List;
/**
 * Model used to store the address book in memory.
 * 
 * @author Xavier
 *
 */
public class Model implements IModel{

	private DBConnection conn = null;
	
	private Model(){
		conn = new DBConnection();
	}
	
	// Singleton, only one model
	private static Model singleton = new Model();
	
	public static Model getInstance(){
		return singleton;
	}
	
	// The address book
	private List<Entry> currentAddressBook = DBConnection.getBook();
	
	public List<Entry> getCurrentAddressBook() {
		return currentAddressBook;
	}

	public void setCurrentAddressBook(List<Entry> currentAddressBook) {
		this.currentAddressBook = currentAddressBook;
	}
	
	public void addEntry(Entry e){
		conn.addEntry(e);
		currentAddressBook.add(e);
	}
	
	public void removeEntry(Entry e){
		conn.removeEntry(e);
		currentAddressBook.remove(e);
	}
}
