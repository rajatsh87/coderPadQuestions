import java.util.Map;
import java.util.HashMap;

public class Length_Of_Cycle {

  /**
   *
   * You have an integer array.
   * Starting from arr[startIndex], follow each element to the index it points to.
   * Continue to do this until you find a cycle.
   * Return the length of the cycle. If no cycle is found return -1
   *
   */
  public static int countLengthOfCycle(int[] arr, int startIndex) {
    // your code goes here
    int pos = startIndex;
    int cycle = 1;
    int f = 0;
    while (pos > -1 && pos < arr.length && arr[pos] != startIndex) {
      pos = arr[pos];
      cycle++;
      if (pos > -1 && pos < arr.length && arr[pos] == startIndex) {
        f = 1;
      }
    }
    return f == 0 ? -1 : cycle;
  }

  public static void main(String[] args) {

    boolean testsPassed = true;

    testsPassed &= countLengthOfCycle(new int[] { 1, 0 }, 0) == 2;
    testsPassed &= countLengthOfCycle(new int[] { 1, 2, 3 }, 0) == -1;

    if (testsPassed) {
      System.out.println("Test passed.");
      // return true;
    } else {
      System.out.println("Test failed.");
      // return false;
    }
  }
}