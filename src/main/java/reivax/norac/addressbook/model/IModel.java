package reivax.norac.addressbook.model;

import java.util.List;

/**
 * Interface listing methods for the Model
 * 
 * @author Xavier
 *
 */
public interface IModel {

	/**
	 * Returns the current address book.
	 * 
	 * @return the list of Entry entities
	 */
	public List<Entry> getCurrentAddressBook();
	
	/**
	 * Sets the current address book.
	 * 
	 * @param currentAddressBook
	 */
	public void setCurrentAddressBook(List<Entry> currentAddressBook);
	
	/**
	 * Adds an Entry to the address book.
	 * 
	 * @param e the Entry to be added
	 */
	public void addEntry(Entry e);
	
	/**
	 * Removes an Entry from the address book.
	 * 
	 * @param e the Entry to be removed
	 */
	public void removeEntry(Entry e);
}
