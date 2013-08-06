import junit.framework.TestCase;

import java.util.List;

/**
 * Make sure that CallTrack fragment actually works as shown.
 */
public class CallTrackTest extends TestCase {
	Person[] testData = {
		new Person("Ian", "Darwin"),		// 1
		new Person("Davy", "Jones"),		// 3
		new Person("Donald", "Duck"),		// 2
		new Person("Austine", "Azalia"),	// 0
	};

	protected CallTrack ct = new CallTrack();

	public void testIt() {
		for (int i = 0; i < testData.length; i++) {
			ct.add(testData[i]);
		}
		List it = ct.usrList;
		assertEquals(it.get(0), testData[3]);
		assertEquals(it.get(1), testData[0]);
		assertEquals(it.get(2), testData[2]);
		assertEquals(it.get(3), testData[1]);
	}
}
