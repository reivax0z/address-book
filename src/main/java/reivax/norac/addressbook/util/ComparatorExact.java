package reivax.norac.addressbook.util;

import java.util.Comparator;

import reivax.norac.addressbook.model.Entry;

public class ComparatorExact implements Comparator<Entry> {

	public int compare(Entry o1, Entry o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}
}
