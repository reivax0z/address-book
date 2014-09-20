package reivax.norac.addressbook.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ComparatorCloseTest.class, 
	ComparatorExactTest.class,
	SearchManagerTest.class })
public class AllTests {

}
