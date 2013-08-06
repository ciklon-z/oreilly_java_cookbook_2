import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Your basic, minimal, Hello World type program in Java.
 * $Id: HelloWorld.java,v 1.2 2003/11/25 17:29:31 ian Exp $
 */
public class HelloWorld {
	public static void main(String[] argv) {
		String message = "Hello, World of Java";
		JFrame jf = new JFrame(message);
		jf.getContentPane().add(new JLabel(message));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
