import java.util.*;

public class SmallestNumber {

  /*
   * public static int FindMin(int a[])
   * Returns the smallest number in array that has been rotated
   * For example - Array {3,4,5,6,1,2} returns 1
   */

  public static int FindMin(int a[]) {
    int min = 0;
    int max = a.length;
    if(max==1) return a[0];
    if (max > 2) {
      while (min < max) {
        int mid = (min + max) / 2;
        if (mid + 1 < a.length && a[mid] > a[mid + 1]) {
          // System.out.println();
          return a[mid + 1];
        }
        if (mid - 1 > 0 && a[mid] < a[mid + 1]) {
          return a[mid - 1];
        }

        if (a[min] < a[mid]) {
          min = mid + 1;
        } else {
          max = mid - 1;
        }
      }
      return a[0];
    }
    else{
      return a[0]<a[1]?a[0]:a[1];
    }
  }

  public static void main(String args[]) {
    boolean result = true;
    result = result && FindMin(new int[] { 3, 4, 5, 6, 1, 2 }) == 1;
    result = result && FindMin(new int[] { 2, 1 }) == 1;
    result = result && FindMin(new int[] { 1 }) == 1;

    try {
      FindMin(null);
      result = false;
    } catch (Exception e) {
      result = result && true;
    }

    if (result) {
      System.out.println("All tests pass");
    } else {
      System.out.println("There are test failures");
    }
  }
}