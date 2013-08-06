import java.io.*;

/** CheckSum - print the checksum of a file
 * @author Ian F. Darwin, http://www.darwinsys.com/
 * @version $Id: CheckSum.java,v 1.6 2004/06/16 20:40:47 ian Exp $
 */

public class CheckSum {
    public static void main(String[] av) {
        CheckSum c = new CheckSum();
		int sum = 0;
        if (av.length == 0)
            sum = c.process(new BufferedReader(
					new InputStreamReader(System.in)));
        else for (int i=0; i<av.length; i++)
			try {
				sum += c.process(new BufferedReader(new FileReader(av[i])));
			} catch (FileNotFoundException e) {
				System.err.println(e);
			}
		System.out.println(sum);
    }


    /** CheckSum one text file, given an open BufferedReader.
	 * Checksumm does not include line endings, so will give the
	 * same value for given text on any platform. Do not use
	 * on binary files!
	 */
    public int process(BufferedReader is) {
		int sum = 0;
        try {
            String inputLine;

            while ((inputLine = is.readLine()) != null) {
				int i;
				for (i=0; i<inputLine.length(); i++) {
					sum += inputLine.charAt(i);
				}
            }
            is.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
		}
		return sum;
    }
}
