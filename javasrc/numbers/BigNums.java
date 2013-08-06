import java.math.*;

/**
 * Demonstrate large numbers.
 * @author Ian F. Darwin, http://www.darwinsys.com/
 * @version $Id: BigNums.java,v 1.4 2004/02/09 03:33:56 ian Exp $
 */
public class BigNums {
	public static void main(String[] argv) {
		//+
		System.out.println("Here's Long.MAX_VALUE: " + Long.MAX_VALUE);
		BigInteger bInt = new BigInteger("3419229223372036854775807");
		System.out.println("Here's a bigger number: " + bInt);
		System.out.println("Here it is as a double: " + bInt.doubleValue());
		//-
	}
}
