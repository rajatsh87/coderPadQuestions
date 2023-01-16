/* Problem Name is &&& Snowpack &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
** Instructions to candidate.
**  1) Given an array of non-negative integers representing the elevations
**     from the vertical cross section of a range of hills, determine how
**     many units of snow could be captured between the hills. 
**
**     See the example array and elevation map below.
**                                 ___
**             ___                |   |        ___
**            |   |        ___    |   |___    |   |
**         ___|   |    ___|   |   |   |   |   |   |
**     ___|___|___|___|___|___|___|___|___|___|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**                                 ___
**             ___                |   |        ___
**            |   | *   *  _*_  * |   |_*_  * |   |
**         ___|   | *  _*_|   | * |   |   | * |   |
**     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**
**     Solution: In this example 13 units of snow (*) could be captured.
**  
**  2) Consider adding some additional tests in doTestsPass().
**  3) Implement computeSnowpack() correctly.
*/

import java.io.*;
import java.util.*;

class Snowpack {
  /*
   ** Find the amount of snow that could be captured.
   */
  public static Integer computeSnowpack(Integer[] arr) {
    int len = arr.length;
    int a1[] = new int[len];
    int a2[] = new int[len];
    int lMax = 0;
    int rMax = 0;
    for (int i = 0; i < len; i++) {
      lMax = Math.max(lMax, arr[i]);
      a1[i] = lMax;
    }
    for (int i = len - 1; i >= 0; i--) {
      rMax = Math.max(rMax, arr[i]);
      a2[i] = rMax;
    }
    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += Math.min(a1[i], a2[i]) - arr[i];
    }
    return sum;
  }

  public static Integer computeSnowpack2(Integer[] arr) {
    int leftMax = 0;
    int rightMax = 0;
    int left = 0;
    int right = arr.length-1;
    int sum = 0;
    while (left < right) {
      if (arr[left] <= arr[right]) {
        leftMax = Math.max(leftMax, arr[left]);
        sum += (leftMax - arr[left]);
        left++;
      } else {
        rightMax = Math.max(rightMax, arr[right]);
        sum += (rightMax - arr[right]);
        right--;
      }
    }
    return sum;
  }

  /*
   ** Returns true if the tests pass. Otherwise, returns false;
   */
  public static boolean doTestsPass() {
    boolean result = true;
    result &= computeSnowpack2(new Integer[] { 0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0 }) == 13;

    return result;
  }

  /*
   ** Execution entry point.
   */
  public static void main(String[] args) {
    if (doTestsPass()) {
      System.out.println("All tests pass");
    } else {
      System.out.println("Tests fail.");
    }
  }
}