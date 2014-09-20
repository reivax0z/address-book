package reivax.norac.addressbook.model;

import java.util.List;

/**
 * Interface listing methods for the Model
 * 
 * @author Xavier
 *
 */
public interface IModel {

	public List<Entry> getCurrentAddressBook();
	
	public void setCurrentAddressBook(List<Entry> currentAddressBook);
	
	public void addEntry(Entry e);
	
	public void removeEntry(Entry e);
}
