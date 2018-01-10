import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class main {
	public static final int INITIALIZE_RESOURCES = 100000; // Variable to initialize resources, else poor results
	public static final int INITIALIZE_RESOURCES2 = 0; // Variable to initialize resources, else poor results

	public static void main(String[] args) {
		averageBenchmark();
	}

	/***************************
	 * AVERAGE BENCHMARK
	 ***************************/
	public static void averageBenchmark() {
		// Array to test inputs from (1 to 10,000)
		int[] numElements = new int[] { INITIALIZE_RESOURCES, INITIALIZE_RESOURCES2, INITIALIZE_RESOURCES2, 1, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000 };

		// Benchmark results for a total of 10 times
		for (int i = 1; i <= 10; i += 1) {
			System.out.println("Test " + i);
			benchmark(numElements.length, numElements); // (to what element in numElements, numElement's values)
			System.out.println("");
		}
	}

	/***************************
	 * BENCHMARK ALGORITHM
	 ***************************/
	public static void benchmark(int x, int[] y) {
		int[][] myTests = getArray(x, y);

		for (int[] jagArray : myTests) {
			algTime(jagArray);
		}
	}

	/***************************
	 * CREATE JAGGED ARRAY
	 ***************************/
	public static int[][] getArray(int x, int[] y) {
		// Create Jagged array with numElement rows
		int[][] result = new int[x][];

		// Create rows with numElement's values
		for (int i = 0; i < x; i += 1) {
			int[] inputinput = new int[y[i]];
			result[i] = populate(inputinput);
		}

		return result;
	}

	/***************************
	 * POPULATE ARRAY
	 ***************************/
	public static int[] populate(int[] input) {
		Random rand = new Random();

		// Iterate through and populate with numbers from (-5000, 10,000)
		for (int i = 0; i < input.length; i += 1) {
			input[i] = rand.nextInt(10000) - 5000;
		}

		return input;
	}

	/***************************
	 * ALGORITHM TIME
	 ***************************/
	public static void algTime(int[] input) {
		// Array to Integer List
		List<Integer> myList = arrayToList(input);

		// Algorithm Timer
		long start = System.nanoTime();
		Merge.mergeSort(myList);
		long finish = System.nanoTime();

		long algTime = finish - start;

		// If it's initalizing resources don't print anything (garbage)
		if (input.length == INITIALIZE_RESOURCES || input.length == INITIALIZE_RESOURCES2) {

		}

		// Not garbage, print stuff
		else {
			System.out.println("It takes " + algTime + " nano seconds to sort an array of size " + input.length);
		}
	}

	/***************************
	 * ARRAY TO INTEGER LIST
	 ***************************/
	private static List<Integer> arrayToList(int[] input) {
		// Create List of Integers
		List<Integer> list = new ArrayList<>();

		// Loop through and add to the list
		for (int i : input) {
			list.add(i);
		}

		return list;
	}
}
