import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This program prints set of anagrams together in given string 
 * 
 * eg. 
 * setOfAnagrams("cat dog tac sat tas god dog") should print "cat tac dog god dog sat tas"
 *
 */

class Group_Anagram {
  
  static String input = "cat dog tac sat tas god dog";
  
  static void setOfAnagrams(String inputString){ 
    
    //your code goes here
    String val[]=inputString.split(" ");
    Map<String,ArrayList<String>>map=new HashMap<>();
    for(int i=0;i<val.length;i++){
      String word=val[i];
      String sortedString=sortedString(word);
      
      if(map.containsKey(sortedString)){
        List<String> values=map.get(sortedString);
        values.add(word);
      }

      else{
        ArrayList<String> list=new ArrayList<String>();
        list.add(word);
        map.put(sortedString, list);
      }
    }
    
    String ans="";
    for(Map.Entry<String,ArrayList<String>>i:map.entrySet()){
      ans=ans+i.getValue();
    }

    System.out.println(ans);

    
  }
  
  
  private static String sortedString(String word) {
    List<Character> list=new ArrayList<>();
    for(int i=0;i<word.length();i++){
      list.add(word.charAt(i));
    }
    list.sort((a,b)->{
      if(a>b) return 1;
      else return -1;
    });

    return list.toString();
  }


  public static void main(String[] args) {
    
    String input = "cat dog tac sat tas god dog";
    setOfAnagrams(input);
    
  }
}