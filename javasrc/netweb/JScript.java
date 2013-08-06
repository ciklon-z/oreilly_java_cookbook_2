import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import netscape.javascript.*; 

/* An Applet to perform JavaScript directly.
 * The import of netscape.javascript.* requires a JAR file.
 * EXPECT COMPILE ERROR unless you have the Netscape JAR file.
 * This may be e.g., $NETSCAPEHOME/java/classes/java40.jar.
 * The use of JavaScript requires <applet ... mayscript="true">
 * @author Ian F. Darwin, http://www.darwinsys.com/
 * @author Roger Goudarzi -- provided background information.
 * @version $Id: JScript.java,v 1.6 2004/02/16 02:44:14 ian Exp $
 */
public class JScript extends java.applet.Applet {
	JSObject jsObject;

	public void init() {
		jsObject = JSObject.getWindow(this);
		Button b = new Button("CLOSE BROWSER");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jsObject.eval("window.close()");
			}
		});
		add(b);
	}
}
