import java.util.*;

/*
 * Implement a run length encoding function.
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 */
public class Length_Encoding {

  public static String rle(String input) {
    
	Map<Character,Integer> map=new TreeMap<>();
	for(int i=0;i<input.length();i++){
		char ch=input.charAt(i);
		if(map.containsKey(ch)){
			map.put(ch,map.get(ch)+1);
		}
		else
			map.put(ch,1);
	}

	String ans="";
	for(Map.Entry<Character,Integer> set:map.entrySet()){
		ans=ans+set.getKey()+set.getValue();
	}

	return ans;
  }


 public static void main(String[] args)  {
    
	  if("".equals(rle("")) && 
			  "a1".equals(rle("a")) && 
			  "a3b2c1".equals(rle("acaabb"))){
		  System.out.println("Passed");
	  }else {
		  System.out.println("Failed");
	  }
  }
}