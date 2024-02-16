
public interface TestingFunctions {
	
	/**
	 * This method calculates and returns the GCD of a and b using a binary calculation
	 * method based on the pseudo code retrieved from Wikipedia on 4/5/18 
	 * (original pseudo code show below method)
	 * @param a - the first integer, must be positive
	 * @param b - the second integer, must be positive
	 * @return gcd of a and b, if a or b is negative returns -1
	 */
	public int greatestCommonDivisor(int a, int b);
	
	/**
	 * This method reverses the subsection of the passed array defined by index1 
	 * and index2. index2 is non-inclusive and will not be swapped with index1. If
	 * index1 > index2 then the two indexes will be swapped before they are checked
	 * for validity.
	 * @param arr - the array to reverse
	 * @param index1 - the first index of the subsection
	 * @param index2 - the non-inclusive upper bound of the subsection, 
	 * last element swapped will be at the index (index2 - 1)
	 * @throws IndexOutOfBoundsException if index1 or (index2-1) are not valid indexes of arr
	 */
	public void reverseWindow(int[] arr, int index1, int index2) throws IndexOutOfBoundsException;

}
