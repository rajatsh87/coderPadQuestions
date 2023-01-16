public class SquareRoot {
  /*
  *   double squareRoot( double x )
  *
  */

  public static double squareRoot( double x )
  {
    double min=0.0;
    double max=x;
    while(max>min){
      double mid=(min+max)/2.0;
      double sq=mid*mid;
      if(Math.abs(sq - x) < 0.00001 || sq==x){
        return mid;
      }
      else{
        if(sq<x){
          min=mid;
        }
        else{
          max=mid;
        }
      }
    }
    return 0.0;
  }

  public static void main( String args[])
  {
    double[] inputs = {2, 4, 100};
    double[] expected_values = { 1.41421, 2, 10 };
    double threshold = 0.001;
    for(int i=0; i < inputs.length; i++)
    {
      if( Math.abs(squareRoot(inputs[i])-expected_values[i])>threshold )
      {
        System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i]) );
      }
    }
    System.out.println( "All tests passed");
  }
}