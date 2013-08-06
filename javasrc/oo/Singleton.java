/** An example of a Singleton implementation in Java.
 * The Singleton design pattern is described in GOF; the idea is to ensure
 * that only one instance of the class will exist in a given application.
 * @author Ian F. Darwin, http://www.darwinsys.com/
 * @version $Id: Singleton.java,v 1.7 2004/02/09 03:33:58 ian Exp $
 */
public class Singleton {

	private static Singleton singleton = new Singleton();

	/** A private Constructor prevents any other class from instantiating. */
	private Singleton() {
	}

	/** Static 'instance' method */
	public static Singleton getInstance() {
		return singleton;
	}

	// other methods protected by singleton-ness would be here...

	/** A simple demo method */
	public String demoMethod() {
		return "demo";
	}
}
