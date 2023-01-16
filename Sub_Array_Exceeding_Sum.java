import java.io.*;
import java.util.*;

public class Sub_Array_Exceeding_Sum
{
  public static int subArrayExceedsSum(int arr[], int x )
  {
    // Initialize current sum and minimum length
    int n=arr.length;
		int curr_sum = 0, min_len = n + 1;

		// Initialize starting and ending indexes
		int start = 0, end = 0;
		while (end < n) {
			// Keep adding array elements while current sum
			// is smaller than or equal to x
			while (curr_sum <= x && end < n)
				curr_sum += arr[end++];

			// If current sum becomes greater than x.
			while (curr_sum > x && start < n) {
				// Update minimum length if needed
				if (end - start < min_len)
					min_len = end - start;

				// remove starting elements
				curr_sum -= arr[start++];
			}
		}
		return min_len==n+1?-1:min_len;
  }

  /**
   * Execution entry point.
  */
  public static void main(String[] args)
  {
   boolean result = true; 
  int[] arr = { 1, 2, 3, 4 };
  result = result && subArrayExceedsSum( arr, 6 ) == 2;
  result = result && subArrayExceedsSum( arr, 12 ) == -1;

  if( result )
  {
    System.out.println("All tests pass\n");
  }
  else
  {
    System.out.println("There are test failures\n");
  }
  }
};