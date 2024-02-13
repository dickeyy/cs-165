import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestCases {

	// Switch which line is commented out in order to test the correct vs broken
	// code
	TestingFunctions functions = new BlackBoxCorrect();
	// TestingFunctions functions = new BlackBoxIncorrect();

	/**
	 * This is a simple validity check for the method greatestCommonDivisor. Checks
	 * that the method
	 * returns the correct result for a known GCD problem gcd(2,4) = 2
	 */
	@Test
	public void testGCD() {
		// Test the GCD of 2 and 4
		assertEquals(2, functions.greatestCommonDivisor(2, 4));
	}

	@Test
	public void testGCD2() {
		// test the gcd of a negative number
		assertEquals(-1, functions.greatestCommonDivisor(-1, 4));
	}

	@Test
	public void testGCD3() {
		// test the gcd of 0, expect 1
		assertEquals(4, functions.greatestCommonDivisor(0, 4));
	}

	@Test
	public void testGCD4() {
		// test the input with a gcd of 1
		assertEquals(1, functions.greatestCommonDivisor(1, 4));
	}

	/**
	 * This is a simple check of the reverseWindow method. Checks if the method will
	 * reverse the entire contents
	 * of the passed array correctly.
	 */
	@Test
	public void testReverseWindow() {
		// Test the reverse of the entire array
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] expected = { 5, 4, 3, 2, 1 };
		// Call the method and check the result
		functions.reverseWindow(arr, 0, arr.length);
		assertTrue(Arrays.equals(expected, arr));
	}

	@Test
	public void testReverseWindow2() {
		// test the input indices out of bound of the array size
		int[] arr = { 1, 2, 3, 4, 5 };
		try {
			functions.reverseWindow(arr, 0, arr.length + 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// pass
		}
	}

	@Test
	public void testReverseWindow3() {
		// Input indices at the bounds of the array size
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] expected = { 1, 5, 4, 3, 2 };
		functions.reverseWindow(arr, 1, arr.length);
		assertTrue(Arrays.equals(expected, arr));
	}

	@Test
	public void testReverseWindow4() {
		// Reversed input indices, expect the same result as testReverseWindow3
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] expected = { 1, 5, 4, 3, 2 };
		functions.reverseWindow(arr, arr.length, 1);
		assertTrue(Arrays.equals(expected, arr));
	}

	@Test
	public void testReverseWindow5() {
		// Input with an empty array, expect an index out of bounds exception
		int[] arr = {};
		try {
			functions.reverseWindow(arr, 0, 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// pass
		}
	}

	@Test
	public void testReverseWindow6() {
		// Input with equal indices
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] expected = { 1, 2, 3, 4, 5 };
		functions.reverseWindow(arr, 2, 2);
		assertTrue(Arrays.equals(expected, arr));
	}

	// For completion, write additonal tests as described in the lab documentation.
}
