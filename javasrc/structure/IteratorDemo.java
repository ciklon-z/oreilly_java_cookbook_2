import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/** Iterator used to walk through a List.
 * @version $Id: IteratorDemo.java,v 1.2 2004/03/08 00:42:18 ian Exp $
 */
public class IteratorDemo {

	public static void main(String[] argv) {

		List l = new ArrayList();
		StructureDemo source = new StructureDemo(15);

		// Add lots of elements to the list...
		l.add(source.getDate());
		l.add(source.getDate());
		l.add(source.getDate());

		int i = 0;

		Iterator it = l.iterator();

		// Process the data structure using an iterator.
		// This part of the code does not know or care
		// if the data is an an array, a List, a Vector, or whatever.
		while (it.hasNext()) {
			Object o = it.next();
			System.out.println("Element " + i++ + " = " + o);
		}
	}
}
