/**
 *  
 *  e.g.
 *      for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).
 */

import java.util.*;

public class Longest_Uniform_String {

  private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

  static int[] longestUniformSubstring(String input){
    if(input.length()==0)
      return new int[]{ -1,0 };
    int longestStart = -1;
    int max=-1;
    int count=0;
    for(int i=1;i<input.length();i++){
      if(input.charAt(i)==input.charAt(i-1)){
        count++;
        if(count>max){
          longestStart=i-count;
          max=count;
        }
      }else{
        count=0;
      }
    }
    System.out.println("longestStart:"+longestStart+"\tlongestLength:"+(max+1));
    // System.out.println();
    // your code goes here
    return new int[]{ longestStart, max+1 };
  }

  public static void main(String[] args) {
    testCases.put("", new int[]{-1, 0});
    testCases.put("10000111", new int[]{1, 4});
    testCases.put("aabbbbbCdAA", new int[]{2, 5});

    boolean pass = true;
    for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
      int[] result = longestUniformSubstring(testCase.getKey());
      pass = pass && (Arrays.equals(result, testCase.getValue()));
    }
    if(pass){
      System.out.println("Pass!");
    } else {
      System.out.println("Failed! ");
    }
  }
}