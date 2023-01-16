import java.io.*;
import java.util.*;

/**
 * Pangram FInder
 *
 * The sentence "The quick brown fox jumps over the lazy dog" contains
 * every single letter in the alphabet. Such sentences are called pangrams.
 * Write a function findMissingLetters, which takes a String `sentence`,
 * and returns all the letters it is missing
 *
 */
class Panagram {

  private static class PanagramDetector {
  private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

  public String findMissingLetters(String sentence) {
    sentence.toLowerCase();
    Set <Character> baseSet=new HashSet<>();
    Set <Character> dereviedSet=new HashSet<>();
    for(char i='a';i<='z';i++){
      baseSet.add(i);
    }

    for(int i=0;i<sentence.length();i++){
      dereviedSet.add(sentence.charAt(i));
    }

    String ans="";
    for(char i:baseSet){
      if(!dereviedSet.contains(i)){
        ans+=i;
      }
    }
    
    return ans;
  }

  }

  public static void main(String[] args) {
  PanagramDetector pd = new PanagramDetector();
  boolean success = true;

  success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
  success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

  if (success) {
    System.out.println("Pass ");
  } else {
    System.out.println("Failed");
  }
  }
}