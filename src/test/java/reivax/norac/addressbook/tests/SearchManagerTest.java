package reivax.norac.addressbook.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import reivax.norac.addressbook.model.Entry;
import reivax.norac.addressbook.util.ComparatorClose;
import reivax.norac.addressbook.util.ComparatorExact;
import reivax.norac.addressbook.util.SearchManager;

public class SearchManagerTest {

	@Test
	public void testSearchEngine() {
		SearchManager<Entry> tester = new SearchManager<Entry>();
		List<Entry> book = new ArrayList<Entry>();
		
		Entry searchedItem = new Entry();
		searchedItem.setName("Bob");
		
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
		
		List<Entry> matchedNames = tester.searchEngine(searchedItem, book, new ComparatorExact());
		List<Entry> closeNames = tester.searchEngine(searchedItem, book, new ComparatorClose());
		
		assertEquals("Exat macth", 1, matchedNames.size());
//		assertEquals("Close macth", 2, closeNames.size());
	}
}
