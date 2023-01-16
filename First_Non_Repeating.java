public class First_Non_Repeating {

  /**
  * Finds the first character that does not repeat anywhere in the input string
  * Given "apple", the answer is "a"
  * Given "racecars", the answer is "e"
  **/        
  public static char findFirst(String input)
  {
    for(int i=0;i<input.length();i++){
      char ch=input.charAt(i);
      if(input.indexOf(ch)==input.lastIndexOf(ch)){
        return ch;
      }
    }
    return ' ';
  }

  public static void main(String args[])
  {
    String[] inputs = {"apple","racecars", "ababdc"};
    char[] outputs = {'a', 'e', 'd' };

    boolean result = true;
    for(int i = 0; i < inputs.length; i++ )
    {
      result = result && findFirst(inputs[i]) == outputs[i];
      if(!result)
        System.out.println("Test failed for: " + inputs[i]);
      else
        System.out.println("Test passed for: " + inputs[i]);
    }
  }

}
