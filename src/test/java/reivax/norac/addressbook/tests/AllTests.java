package reivax.norac.addressbook.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * List of all tested classes.
 * 
 * @author Xavier
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ 
	ComparatorCloseTest.class, 
	ComparatorExactTest.class,
	JsonDecodeTest.class,
	SearchManagerTest.class })
public class AllTests {

}
