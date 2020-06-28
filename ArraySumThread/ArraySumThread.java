import java.util.List;

/**
 * This is a thread class that sums up the numbers found in certain range in the
 * given array.
 *
 */
public class ArraySumThread extends Thread {

	// The numbers array.
	private int[] numArr = null;

	// The index from which the numbers should be summed.
	private int fromIndex;

	// The number of elements to be summed.
	private int numberOfElements;

	// The list to which the results should be set.
	private List<Integer> resultList;

	// constructor
	public ArraySumThread(String threadName, int[] numArr, int fromIndex, int numberOfElements,
			List<Integer> resultList) {
		super(threadName);

		this.numArr = numArr;
		this.fromIndex = fromIndex;
		this.numberOfElements = numberOfElements;
		this.resultList = resultList;
	}

	// The run method.
	public void run() {
		// Decide the from and to index of array elements to include in the sum.
		int length = fromIndex + numberOfElements;
		if (length > numArr.length) {
			length = numArr.length;
		}

		// Sum the array elements.
		int sum = 0;
		for (int i = fromIndex; i < length; i++) {
			sum += numArr[i];
		}
		// Add the result to the resultList
		synchronized (resultList) {
			resultList.add(sum);
		}
	}
}