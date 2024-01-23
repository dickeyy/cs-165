import java.util.Arrays;

public class LabProgram {

    public static int[] removeEvens(int[] nums) {

        // Create a new array with the same length as nums
        int[] result = new int[nums.length];

        // Initialize a counter to keep track of the number of odd numbers
        int oddCount = 0;

        // Iterate through nums
        for (int i = 0; i < nums.length; i++) {

            // If the current number is odd
            if (nums[i] % 2 == 1) {

                // Add it to the result array
                result[oddCount] = nums[i];

                // Increment the counter
                oddCount++;
            }

            // handle negative numbers
            if (nums[i] % 2 == -1) {

                // Add it to the result array
                result[oddCount] = nums[i];

                // Increment the counter
                oddCount++;
            }
        }

        return Arrays.copyOf(result, oddCount);

    }

    public static void main(String[] args) {

        int[] input = { -5, -3, -1, 1, 3, 5 };
        int[] result = removeEvens(input);

        // Helper method Arrays.toString() converts int[] to a String
        System.out.println(Arrays.toString(result)); // Should print [1, 3, 5, 7, 9]
    }
}
