package reivax.norac.addressbook.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import reivax.norac.addressbook.model.Entry;

/**
 * Helper class for searching engine.
 * 
 * @author Xavier
 *
 */
public class SearchManager<T> {

	/**
	 * Get all matching records according to a given Comparator
	 * 
	 * @param e the searched Entry
	 * @param list the list to be searched
	 * @param c the Comparator to be used
	 * @return the list of all matching Entry
	 */
	public List<T> searchEngine(T e, List<T> list, Comparator<T> c){
		List<T> matchedNames = new ArrayList<T>();

		List<T> subList = new ArrayList<T>(list.subList(0, list.size()));
		int index = Collections.binarySearch(subList, e, c);
		
		while(index >= 0){
			matchedNames.add(subList.get(index));
			subList.remove(index);
			index = Collections.binarySearch(subList, e, c);
		}
		
		return matchedNames;
	}
}
