
/**
 * Make an array of 200 million random numbers between 1 and 10. Compute the sum
 * in parallel using multiple threads. Then compute the sum with only one
 * thread, and display the sum and times for both cases.
 */

public class RandomNumberSumUsingThreads {

	// The maximum number of 'random numbers' to be generated.
	public static final int MAX_RANDOM_NUMBERS = 200000000; // 200 million.

	// The random numbers generated.
	public static final int[] numArr = new int[MAX_RANDOM_NUMBERS];

	// The min value of random number.
	private static final int MIN = 1;

	// The max value of random number.
	private static final int MAX = 10;

	// main method
	public static void main(String[] args) {
		compareSingleAndMultipleThreads();
	}

	// Compare the time taken to sum the random numbers using single and multiple
	// threads.
	public static boolean compareSingleAndMultipleThreads() {

		// Generate random numbers.
		generateRandomNumbers();

		System.out.println("Total random numbers: " + MAX_RANDOM_NUMBERS);
		System.out.println("----------");
		// Run MULTIPLE Threads
		MultipleThreads multiple = new MultipleThreads(numArr);
		// start time
		long startTime = System.currentTimeMillis();
		int sum = multiple.sum();
		// Print results.
		System.out.println("MULTIPLE threads results: ");
		System.out.println("Sum of random values: " + sum);
		// end time
		long endTime = System.currentTimeMillis();

		// Compute total time
		long totalTime = endTime - startTime;
		System.out.println("Total time taken: " + totalTime + " milliseconds.");
		System.out.println("----------");

		// Run SINGLE Threads
		System.out.println("----------");
		SingleThread single = new SingleThread(numArr);
		// start time
		startTime = System.currentTimeMillis();
		int sum2 = single.sum();

		// Print results.
		System.out.println("SINGLE thread results: ");
		System.out.println("Sum of random values: " + sum2);

		// end time
		endTime = System.currentTimeMillis();

		// Compute total time
		totalTime = endTime - startTime;
		System.out.println("Total time taken: " + totalTime + " milliseconds.");
		System.out.println("----------");

		if (sum == sum2) {
			return true;
		} else {
			return false;
		}
	}

	// Generate random numbers.
	private static void generateRandomNumbers() {
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = getRandomNumber(MIN, MAX);
		}
	}

	// Returns a random number in the range of given min and max.
	private static int getRandomNumber(int min, int max) {
		int randomInt = 0;
		while (true) {
			double randomDouble = Math.random();
			// Multiply by 10
			// Convert to int to avoid decimal values.
			randomInt = (int) (randomDouble * 10);
			if (randomInt < min || randomInt > max) {
				continue;
			} else {
				break;
			}
		}
		return randomInt;
	}

}
