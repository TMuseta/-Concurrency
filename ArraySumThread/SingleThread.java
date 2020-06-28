/**
 * Compute the sum of array elements, in single thread.
 * 
 */
public class SingleThread {

	// The random numbers generated.
	private int[] numArr = null;

	/**
	 * constructor
	 * 
	 * @param numArr
	 */
	public SingleThread(int[] numArr) {
		this.numArr = numArr;
	}

	// The method that does the sum and prints the results.
	public int sum() {
		// Sum the values.
		int sum = 0;
		for (int i = 0; i < numArr.length; i++) {
			sum += numArr[i];
		}

		// Return sum.
		return sum;
	}

}
