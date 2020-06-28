import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Compute the sum of array elements, in multiple threads.
 * 
 */
public class MultipleThreads {

	// The random numbers generated.
	public int[] numArr = null;

	// The max number of 'random numbers' that need to be allocated for each thread
	// to sum up.
	private static final int NUMBERS_PER_THREAD = 100000000;

	/**
	 * constructor
	 * 
	 * @param numArr
	 */
	public MultipleThreads(int[] numArr) {
		this.numArr = numArr;
	}

	// The method that does the sum and prints the results.
	public int sum() {

		// Decide the max number of threads required to count.
		int maxThreads = numArr.length / NUMBERS_PER_THREAD;
		int reminder = numArr.length % NUMBERS_PER_THREAD;
		if (reminder > 0) {
			maxThreads += 1;
		}

		// The list to which the results should be added.
		List<Integer> resultList = Collections.synchronizedList(new ArrayList<Integer>());

		// The list containing threads created.
		List<Thread> threadList = new ArrayList<Thread>();

		// Create and start threads.
		int fromIndex = 0;
		for (int i = 0; i < maxThreads; i++) {
			String threadName = "Thread-" + (i + 1);
			ArraySumThread thread = new ArraySumThread(threadName, numArr, fromIndex, NUMBERS_PER_THREAD, resultList);
			fromIndex += NUMBERS_PER_THREAD;
			threadList.add(thread);
			thread.start();
		}

		// Join all threads.
		for (int i = 0; i < threadList.size(); i++) {
			Thread thread = threadList.get(i);
			// System.out.println("Waiting for end of thread: " + thread.getName());
			try {
				thread.join();
				// System.out.println("Finished thread: " + thread.getName());
			} catch (InterruptedException e) {
			}
		}

		// Sum the values returned added by each thread to the resultList
		int sum = 0;
		for (Integer value : resultList) {
			sum += value;
		}

		// Return sum.
		return sum;
	}

}
