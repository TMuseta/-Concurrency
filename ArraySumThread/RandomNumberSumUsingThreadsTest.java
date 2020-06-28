import static org.junit.Assert.assertTrue;

import org.junit.Test;

//Unit test for class RandomNumberSumUsingThreads.
public class RandomNumberSumUsingThreadsTest {

	@Test
	public void test() {
		boolean result = RandomNumberSumUsingThreads.compareSingleAndMultipleThreads();
		assertTrue(result);
	}

}
