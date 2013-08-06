import java.util.Scanner;
/**
 * Read an int from Standard Input, using 1.5
 * @author	Ian F. Darwin, http://www.darwinsys.com/
 * @version 	$Id: ReadStdinInt15.java,v 1.2 2004/03/07 16:31:58 ian Exp $
 */
public class ReadStdinInt15 {
	public static void main(String[] ap) {
		int val;
		try {
			Scanner sc = Scanner.create(System.in);      // Requires J2SE 1.5
			val = sc.nextInt();
		} catch (NumberFormatException ex) {
			System.err.println("Not a valid number: " + ex);
			return;
		}
		System.out.println("I read this number: " + val);
	}
}
