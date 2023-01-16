import java.io.*;
import java.util.*;

/*

** There is a staircase with 'n' number of steps. A child
** walks by and wants to climb up the stairs, starting at
** the bottom step and ascending to the top.instead
** of taking 1 step at a time, it will vary between taking
** either 1, 2 or 3 steps at a time.
** Given 'n' number of steps below method should find
** number of
** unique combinations the child could traverse.
** An example would be countSteps(3) == 4:
** 1 1 1
** 2 1
** 1 2
** 3
*/

/*
 * 
 */

class StairCase
{
  public static Integer countSteps(Integer n)
  {

    if(n==0) return 0;
    if(n==1) return 1;
    if(n==2) return 2;
    if(n==3) return 4;

    else{
      return countSteps(n-1)+countSteps(n-2)+countSteps(n-3);
    }
  }


  public static boolean doTestsPass()
  {
    return countSteps(3) == 4
      && countSteps(4) == 7;
  }

  public static void main(String[] args)
  {
    if(doTestsPass())
    {
      System.out.println("All tests pass");
    }
    else
    {
      System.out.println("Tests fail.");
    }

    for (Integer n = 1; n <= 5; n++)
    {
      Integer numberOfCombinations = countSteps(n);
      System.out.println(n + " steps => " + numberOfCombinations);
    }
  }
}