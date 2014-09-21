package reivax.norac.addressbook.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import reivax.norac.addressbook.model.Entry;
import reivax.norac.addressbook.util.JsonDecode;

/**
 * Tests covering the JsonDecode class.
 * 
 * @author Xavier
 *
 */
public class JsonDecodeTest {

	@Test
	public void testDecodeBook() throws ParseException, IOException {
		
		List<Entry> book = JsonDecode.decodeBook("./src/test/resources/test.json");
		assertEquals("Read content size", 4, book.size());
		
		Entry e = new Entry();
		e.setName("Bob");
		assertTrue("Book contains Bob", book.contains(e));
	}

}
