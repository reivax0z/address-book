package reivax.norac.addressbook.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import reivax.norac.addressbook.model.Entry;
import reivax.norac.addressbook.util.ComparatorClose;
import reivax.norac.addressbook.util.ComparatorExact;

public class ComparatorExactTest {

	@Test
	public void testCompare() {
		ComparatorExact tester = new ComparatorExact();
		Entry e1 = new Entry();
		Entry e2 = new Entry();
		
		e1.setName("Bob");
		e2.setName("Bob");
		assertTrue("Bob and Bob are same", tester.compare(e1, e2) == 0);
		
		e1.setName("Bob");
		e2.setName("BOb");
		assertTrue("Bob and BOb are same", tester.compare(e1, e2) == 0);
		
		e1.setName("Bob");
		e2.setName("BoB");
		assertTrue("Bob and BoB are same", tester.compare(e1, e2) == 0);
		
		e1.setName("Leo");
		e2.setName("Leonidas");
		assertTrue("Leo and Leonidas are different", tester.compare(e1, e2) != 0);
		
		e1.setName("Leo");
		e2.setName("Lea");
		assertTrue("Leo and Lea are different", tester.compare(e1, e2) != 0);
	}

}
