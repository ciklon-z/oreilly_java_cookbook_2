import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** Show the XML serialization added to "java.beans.*" in JDK1.4.
 * Subclass "SerialDemoAbstratBase" to get most of infrastructure
 */
public class SerialDemoXML extends SerialDemoAbstractBase {

	public static final String FILENAME = "serial.xml";

	public static void main(String[] args) throws IOException {
		new SerialDemoXML().save();
		new SerialDemoXML().dump();
	}

	/** Save the data to disk. */
	public void write(Object theGraph) throws IOException {
		XMLEncoder os = new XMLEncoder(		// NEEDS JDK 1.4
			new BufferedOutputStream(
				new FileOutputStream(FILENAME)));
		os.writeObject(theGraph);
		os.close();
	}

	/** Display the data */
	public void dump() throws IOException {
		XMLDecoder inp = new XMLDecoder(		// NEEDS JDK 1.4
			new BufferedInputStream(
				new FileInputStream(FILENAME)));
		System.out.println(inp.readObject());
		inp.close();
	}
}
