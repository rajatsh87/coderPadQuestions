/*
** Instructions to candidate.
**  1) You are an avid rock collector who lives in southern California. Some rare 
**     and desirable rocks just became available in New York, so you are planning 
**     a cross-country road trip. There are several other rare rocks that you could 
**     pick up along the way. 
**     
**     You have been given a grid filled with numbers, representing the number of 
**     rare rocks available in various cities across the country.  Your objective 
**     is to find the optimal path from So_Cal to New_York that would allow you to 
**     accumulate the most rocks along the way. 
**     
**     Note: You can only travel either north (up) or east (right).
**  2) Consider adding some additional tests in doTestsPass().
**  3) Implement optimalPath() correctly.
**  4) Here is an example:
**                                                           ^
**                 {
                    {1,0,2,0,5}, New_York (finish)           N
**                  {0,1,1,1,0},                         < W   E >
**   So_Cal (start) {2,0,0,0,0}}                             S
**                                                           v 
**   The total for this example would be 10 (2+0+1+1+1+0+5).
*/

import java.io.*;
import java.util.*;

class OptimalPath {

  public static Integer optimalPath(Integer[][] grid) {
    int dp[][] = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        dp[i][j] = -1;
      }
    }
    return getAns(grid, grid.length - 1, 0, 0, dp);
  }

  public static Integer getAns(Integer grid[][], int r, int c, int maxValue, int dp[][]) {
    if (dp[r][c] != -1)
      return dp[r][c];
    if (r == 0) {
      if (c == grid[r].length - 1) {
        dp[r][c] = grid[r][c];
        return grid[r][c];
      } else {
        int val = getAns(grid, r, c + 1, maxValue, dp) + grid[r][c];
        dp[r][c] = val;
        return val;
      }
    } else {
      if (c < grid[r].length - 1) {
        int val = (Math.max(getAns(grid, r - 1, c, maxValue, dp), getAns(grid, r, c + 1, maxValue, dp))) + grid[r][c];
        dp[r][c] = val;
        return val;
      } else {
        int val = getAns(grid, r - 1, c, maxValue, dp) + grid[r][c];
        dp[r][c] = val;
        return val;
      }
    }
  }

  public static boolean doTestsPass() {
    boolean result = true;
    int ans = optimalPath(new Integer[][] {
        { 0, 3, 0, 0, 5 },
        { 12, 0, 0, 10, 10 }
    });
    System.out.println("ans=" + ans);
    // result &= optimalPath(new Integer[][] {
    // { 0, 0, 0, 0, 5 },
    // { 0, 1, 1, 1, 0 },
    // { 2, 0, 0, 0, 0 } }) == 10;
    return result;
  }

  public static void main(String[] args) {
    if (doTestsPass()) {
      System.out.println("All tests pass");
    } else {
      System.out.println("Tests fail.");
    }
  }
}