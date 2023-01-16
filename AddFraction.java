public class AddFraction {

  /**
   * Given two fractions passed in as int arrays,
   * returns the fraction which is result of adding the two input fractions.
   */
  public static int[] addFractions( int[] fraction1, int[] fraction2 ) {
    // Write your code here
    // System.out.println(fraction1[0]+"/"+fraction1[1]);
    // System.out.println(fraction2[0]+"/"+fraction2[1]);

    // int gcdvalue=gcd(fraction1[1],fraction2[1]);

    // System.out.println("gcd="+gcdvalue);

    fraction1[0]=fraction1[0]*(fraction2[1]);
    int temp=fraction1[1];
    fraction1[1]=fraction1[1]*(fraction2[1]);

    fraction2[0]=fraction2[0]*(temp);
    fraction2[1]=fraction2[1]*(temp);

    int ans[]=new int[2];
    ans[0]=fraction1[0]+fraction2[0];
    ans[1]=fraction1[1];

    int gcdvalue=gcd(ans[0],ans[1]);

    ans[0]=ans[0]/gcdvalue;
    ans[1]=ans[1]/gcdvalue;

    System.out.println("gcd="+gcdvalue);

    ans[0]=ans[0]/gcdvalue;
    ans[1]=ans[1]/gcdvalue;

    System.out.println(ans[0]+"/"+ans[1]);
    return ( ans);
  }

  static int gcd(int val1,int val2){
    if(val1==0)
      return val2;

    return gcd(val2%val1,val1);
  }

  
  public static void main( String[] args ) {
    int[] result = addFractions( new int[]{ 2, 3 }, new int[]{ 1, 2 } );

    if( result[ 0 ] == 7 && result[ 1 ] == 6 ) {
      System.out.println( "Test passed." );
      // return true;
    } else {
      System.out.println( "Test failed." );
      // return false;
    }
  }
}