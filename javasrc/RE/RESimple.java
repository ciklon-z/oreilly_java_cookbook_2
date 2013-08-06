import java.util.regex.*;

/**
 * Simple example of using RE class.
 * @author Ian F. Darwin, http://www.darwinsys.com/
 * @version $Id: RESimple.java,v 1.4 2004/02/28 02:14:11 ian Exp $
 */
public class RESimple {
	public static void main(String[] argv) {
		String pattern = "^Q[^u]\\d+\\.";
		String input = "QA777. is the next flight. It is on time.";

		Pattern p = Pattern.compile(pattern);

		boolean found = p.matcher(input).lookingAt();

		System.out.println("'" + pattern + "'" +
			(found ? " matches '" : " doesn't match '") + input + "'");
	}
}
