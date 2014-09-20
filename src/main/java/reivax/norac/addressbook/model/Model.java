package reivax.norac.addressbook.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private DBConnection conn = null;
	
	private Model(){
		conn = new DBConnection();
	}
	
	private static Model singleton = new Model();
	
	public static Model getInstance(){
		return singleton;
	}
	
	private List<Entry> currentAddressBook = DBConnection.getBook();
	
	List<Entry> anotherAddressBook = new ArrayList<Entry>();

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
