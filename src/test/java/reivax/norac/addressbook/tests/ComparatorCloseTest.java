package reivax.norac.addressbook.tests;

import org.junit.Test;

import reivax.norac.addressbook.model.Entry;
import reivax.norac.addressbook.util.ComparatorClose;
import junit.framework.TestCase;

/**
 * Tests covering the ComparatorClose class.
 * 
 * @author Xavier
 *
 */
public class ComparatorCloseTest extends TestCase {

	@Test
	public void testReplaceAllOccOfSpecialChars() {
		Entry e1 = new Entry();
		
		e1.setName("Bob");
		assertEquals("BOB", ComparatorClose.replaceAllOccOfSpecialChars(e1.getName()));

		e1.setName("Lea");
		assertEquals("LEA", ComparatorClose.replaceAllOccOfSpecialChars(e1.getName()));

		e1.setName("aeic");
		assertEquals("AEIC", ComparatorClose.replaceAllOccOfSpecialChars(e1.getName()));
	}
	
	@Test
	public void testCompare() {
		ComparatorClose tester = new ComparatorClose();
		Entry e1 = new Entry();
		Entry e2 = new Entry();
		
		e1.setName("Bob");
		e2.setName("Boby");
		assertTrue("Boby and Bob are similar", tester.compare(e1, e2) == 0);
		
		e1.setName("Leo");
		e2.setName("Lea");
		assertTrue("Leo and Lea are different", tester.compare(e1, e2) != 0);
		
		e1.setName("Leo");
		e2.setName("Leonidas");
		assertTrue("Leo and Leonidas are similar", tester.compare(e1, e2) == 0);
		
		e1.setName("Martin");
		e2.setName("Josh");
		assertTrue("Martin and Josh are different", tester.compare(e1, e2) != 0);
	}
}
