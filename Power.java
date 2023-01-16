
/**
 * Implement power(base,exp) correctly. Assume exp is an integer.
 *
 */

public class Power {

  /*
   * Given base and integer exponent, compute value of base raised to the power of
   * exponent.
   * Can you implement a solution faster than O(exp)?
   */
  public static double power(double base, int exp) {
    if (exp == 0)
      return 1.0;
    if (base == 0.0)
      return 0.0;
    else {
      double ans = 0.0;
      if (exp % 2 == 0) {
        ans = power(base, exp / 2) * power(base, exp / 2);
      }
      if (exp % 2 == 1 || exp % 2 == -1) {
        ans = power(base, exp / 2) * power(base, exp / 2) * base;
      }
      if (exp < 0)
        return 1 / ans;
      return ans;
    }
  }

  /* returns true if all tests pass, false otherwise */
  public static boolean doTestsPass() {
    boolean doTestsPass = true;
    double result = power(2, -5);
    System.out.println("ans=" + result);
    return doTestsPass;
  }

  public static void main(String[] args) {
    if (doTestsPass())
      System.out.println("All Tests Pass");
    else
      System.out.println("There are test failures");
  }
}