import java.util.Arrays;

public class Distance_between_two_word_mid_point {

  
   // Input two words returns the shortest distance between their two midpoints in number of characters
   // Words can appear multiple times in any order and should be case insensitive.
   
   // E.g. for the document="Example we just made up"
   // shortestDistance( document, "we", "just" ) == 4
   
  public static double shortestDistance(String document, String word1, String word2) {
    double shortest = Integer.MAX_VALUE;
    int firtWord=0;
    int secondWord=0;
    int lengthCounter=0;
    String words[]=document.split("[,. ]");
    for(int i=0;i<words.length;i++){
      String currWord=words[i];
      if(currWord.equalsIgnoreCase(word1)){
        firtWord=lengthCounter+(currWord.length()/2);
      }
      else if(currWord.equalsIgnoreCase(word2)){
        secondWord=lengthCounter+(currWord.length()/2);
      }
      if(firtWord>0 && secondWord>0){
        shortest=Math.min(shortest,Math.abs(firtWord-secondWord));
      }
      lengthCounter+=currWord.length()+1;
    }
    if(firtWord==0 && secondWord==0){
      return -1;
    }
    return shortest;
  }

  public static boolean pass() {
    return  shortestDistance(document, "and", "graphic") == 6d &&
        shortestDistance(document, "transfer", "it") == 14d &&
        shortestDistance(document, "Design", "filler" ) == 25d;
  }

  public static void main(String[] args) {
    // double ans =shortestDistance( document1, "we", "just" );
    if (pass()) {
      System.out.println("Pass");
    } else {
      System.out.println("Some Fail");
    }
  }

  private static String document1="Example we just made up";


  private static final String document;
  static{
    StringBuffer sb = new StringBuffer();
    sb.append("In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
    sb.append(" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
    sb.append(" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

    document = sb.toString();
  }
}