/**
 * Multiply two matrices.
 * Only defined for int: clone the code (or wait for Templates)
 * for long, float, and double.
 * @author Ian F. Darwin, http://www.darwinsys.com/
 * @version $Id: MatrixUse.java,v 1.3 2004/02/09 03:33:57 ian Exp $
 */
public class MatrixUse {
	public static void main(String[] argv) {
		//+
		int x[][] = {
			{ 3, 2, 3 },
			{ 5, 9, 8 },
		};
		int y[][] = {
			{ 4, 7 },
			{ 9, 3 },
			{ 8, 1 },
		};
		int z[][] = Matrix.multiply(x, y);
		Matrix.mprint(x);
		Matrix.mprint(y);
		Matrix.mprint(z);
		//-
	}
}

