
// find the median of the two sorted arrays.
// ex. {1, 3} and {2} is 2

public class MedianTwoSortedArrays {
  public static double logic(int[] A, int[] B) {
    int arr[] = new int[A.length + B.length];
    int p1 = 0;
    int p2 = 0;
    int p3 = 0;
    while (p1 < A.length || p2 < B.length) {
      int valA = Integer.MAX_VALUE;
      int valB = Integer.MAX_VALUE;
      if (p1 < A.length) {
        valA = A[p1];
      }
      if (p2 < B.length) {
        valB = B[p2];
      }
      int minVal = Math.min(valA, valB);
      arr[p3] = minVal;
      p3++;
      if (minVal == valA) {
        p1++;
      } else if (minVal == valB) {
        p2++;
      }
    }
    double ans;
    if (arr.length % 2 == 0) {
      ans = (arr[arr.length / 2] + arr[(arr.length) / 2 - 1]) / 2.0;
    } else {
      ans = arr[arr.length / 2];
    }
    return ans;
  }

  public static boolean pass() {
    // double vals=logic(new int[]{1, 3,7}, new int[]{2, 4});
    // System.out.println("vals:"+vals);
    boolean result = true;
    result = result && logic(new int[] { 1, 3 }, new int[] { 2, 4 }) == 2.5;
    return result;
  };

  public static void main(String[] args) {
    if (pass()) {
      System.out.println("pass");
    } else {
      System.out.println("some failures");
    }
  }
}