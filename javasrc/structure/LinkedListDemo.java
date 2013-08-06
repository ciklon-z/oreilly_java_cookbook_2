import java.util.*;

/**
 * Demo of 1.2 java.util.LinkedList class
 * using same example as my older LinkList class.
 * @author	Ian Darwin, http://www.darwinsys.com/
 * @version $Id: LinkedListDemo.java,v 1.4 2004/02/09 03:34:04 ian Exp $
 */
public class LinkedListDemo {
	public static void main(String[] argv) {
		System.out.println("Here is a demo of Java 1.2's LinkedList class");
		LinkedList l = new LinkedList();
		l.add(new Object());
		l.add("Hello");
		l.add("end of the list");

		System.out.println("Here is a list of all the elements");
		ListIterator li = l.listIterator(0);
		while (li.hasNext())
			System.out.println("Next to: " + li.next());

		if (l.indexOf("Hello") < 0)
			System.err.println("Lookup does not work");
		else
			System.err.println("Lookup works");

		// Now, for added fun, let's walk the linked list backwards.
		while (li.hasPrevious()) {
			System.out.println("Back to: " + li.previous());
		}
	}
}
