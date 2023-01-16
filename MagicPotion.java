/*
Question: 
Combine ingredients in a specific order, any of which may be repeated

As an example, consider the following  
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E 

Encode the string above using only 6 characters: A,B,*,C,*,E

Implement function that takes as input an un-encoded potion and returns the 
minimum number of characters required to encode

*/

public class MagicPotion {

  private static int minimalSteps(String ingredients) {
    int n = ingredients.length();
    int[] dp = new int[n];
    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      // Check repeat only for even number of characters (odd index)
      if (i % 2 == 1 && (repeatString(ingredients, 0, i / 2, i))) {
        // If repeated use the length of the first block + 1 (for *)
        dp[i] = dp[i / 2] + 1;
      } else {
        // If not just increment
        dp[i] = dp[i - 1] + 1;
      }
    }
    return dp[n - 1];
  }

  /**
   * Checks if string is repeated in i..j and j+1..k
   */
  private static boolean repeatString(String s, int i, int j, int k) {
    return s.substring(i, j + 1).equals(s.substring(j + 1, k + 1));
  }

  public static void main(String[] args) {

    int ans = minimalSteps("CCCCCC");
    System.out.println(ans);
    // if (minimalSteps("ABABCABABCE") == 6
    // && minimalSteps("ABCDABCE") == 8
    // && minimalSteps("ABCABCE") == 5
    // && minimalSteps("AAA") == 3
    // && minimalSteps("AAAA") == 3
    // && minimalSteps("BBB") == 3
    // && minimalSteps("AAAAAA") == 4) {
    // System.out.println();
    // System.out.println("Pass");
    // } else {
    // System.out.println();
    // System.out.println("Fail");
    // }
  }
}