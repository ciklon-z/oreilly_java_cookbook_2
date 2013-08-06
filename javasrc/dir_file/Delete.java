import java.io.*;

/**
 * Delete a file from within Java
 * @author Ian F. Darwin, http://www.darwinsys.com/
 * @version $Id: Delete.java,v 1.5 2004/02/09 03:33:47 ian Exp $
 */
public class Delete {
	public static void main(String[] argv) throws IOException {

		// Construct a File object for the backup created by editing
		// this source file. The file probably already exists.
		// My editor creates backups by putting ~ at the end of the name.
		File bkup = new File("Delete.java~");
		// Quick, now, delete it immediately:
		bkup.delete();
	}
}
