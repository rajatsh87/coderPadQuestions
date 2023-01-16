public class Is_Power_of_10
{
  /**
   * Returns true if x is a power-of-10. 
   */
  public static boolean isPowerOf10(int x)
  {
    int power = 1;
		while (power < x) {
			power = 10 * power;
		}

		return power == x;
  }

  public static boolean doTestsPass()
  {
  int[] isPowerList = {10};
  int[] isNotPowerList = {3};

  for(int i : isPowerList)
  {
    if(!isPowerOf10(i))
    {
    System.out.println("Test failed for: " + i);
    return false;
    }
  }

  for(int i : isNotPowerList)
  {
    if(isPowerOf10(i))
    {
    System.out.println("Test failed for: " + i);
    return false;
    }
  }

  System.out.println("All tested passed");
  return true;
  };


  public static void main(String args[])
  {
  doTestsPass();
  }
}