import java.io.*;

/**
 * Read a file containing an offset, and a String at that offset.
 * @author Ian F. Darwin, http://www.darwinsys.com/
 * @version $Id: ReadRandom.java,v 1.6 2004/03/07 17:30:35 ian Exp $
 */
public class RandomRead {
	final static String FILENAME = "random.dat";
	protected String fileName;
	protected RandomAccessFile seeker;

	public static void main(String[] argv) throws IOException {
		RandomRead r = new RandomRead(FILENAME);

		System.out.println("Offset is " + r.readOffset());
		System.out.println("Message is \"" + r.readMessage() + "\".");
	}

	/** Constructor: save filename, construct RandomAccessFile */
	public RandomRead(String fname) throws IOException {
		fileName = fname;
		seeker = new RandomAccessFile(fname, "r");
	}

	/** Read the Offset field, defined to be at location 0 in the file. */
	public int readOffset() throws IOException {
		seeker.seek(0);				// move to very beginning
		return seeker.readInt();	// and read the offset
	}

	/** Read the message at the given offset */
	public String readMessage() throws IOException {
		seeker.seek(readOffset());	// move to the offset
		return seeker.readLine();	// and read the String
	}
}
