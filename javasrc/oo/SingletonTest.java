import junit.framework.*;

/** Some JUnit test cases for the Singleton demo.
 * @version $Id: SingletonTest.java,v 1.2 2003/11/25 17:29:27 ian Exp $
 */
public class SingletonTest extends TestCase {

	Singleton d1, d2;

	/** setup method */
	public void setUp() {
		d1 = Singleton.getInstance();
		d2 = Singleton.getInstance();
	}

	/** constructor plumbing for junit */
	public SingletonTest(String name) {
		super(name);
	}

	public void testSingleness() { 
		assertTrue(d1 == d2);
	}

	public void testCorrectClass() {
		assertTrue(d1 instanceof Singleton);
	}

	public void testDemoMethod() {
		assertEquals(d1.demoMethod(), "demo");
	}
}
