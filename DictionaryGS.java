import java.util.*;

// Given a a string of letters and a dictionary, the function longestWord should
//     find the longest word or words in the dictionary that can be made from the letters
//     Input: letters = "oet", dictionary = {"to","toe","toes","raj","raja"} letter="rajat"
//     Output: {"toe"}


class Dictionary {
  private String[] entries;

  public Dictionary(String[] entries) {
    this.entries = entries;
  }

  public boolean contains(String word) {
    return Arrays.asList(entries).contains(word);
  }

  public String[] getEntries(){
    return this.entries;
  }
}


public class DictionaryGS {
  public static Set<String> longestWord(String letters, Dictionary dict) {
    Set<String> result = new HashSet<String>();
    int[]wordFreq=new int[26];
    int largestWord=0;
    for(char ch:letters.toCharArray()){
      wordFreq[ch-'a']++;
    }
    for(String word:dict.getEntries()){
      if(isPossible(wordFreq.clone(),word)){
        if(word.length()==largestWord){
          result.add(word);
        }else if(word.length()>largestWord){
          result.clear();
          result.add(word);
        }
      }
    }
    return result;
  }

  public static boolean isPossible(int vals[],String word){
    for(char ch:word.toCharArray()){
      if(vals[ch-'a']==0)
        return false;
      else{
        vals[ch-'a']--;
      }
    }
    return true;
  }


  public static boolean pass() {
    Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana"});
    boolean r = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
    return r;
  }

  public static void main(String[] args) {
    if(pass()) {
      System.out.println("Pass");
    } else {
      System.err.println("Fails");
    }
  }
}