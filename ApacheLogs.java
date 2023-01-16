/*
 *						**** IMPORTANT ****
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 */

 import java.util.HashMap;
 import java.util.Map;
 
 public class ApacheLogs {
 
     public static String findTopIpaddress(String[] inputs) {
        Map<String,Integer> map=new HashMap<>();
        for(String str:inputs){
            String ip=str.substring(0,str.indexOf('-')-1);
            if(map.containsKey(ip)){
                map.put(ip,map.get(ip)+1);
            }else{
                map.put(ip,1);
            }
        }
        int max=-1;
        String nm="";
        for(Map.Entry<String,Integer> entity:map.entrySet()){
            int val=entity.getValue();
            if(val>max){
                nm=entity.getKey();
                max=val;
            }
        }
        return nm;
     }
 
 
 
     public static void main(String[] args) {
 
         String input[] = new String[] {
                 "10.0.0.1 - log entry 1 11",
                 "10.0.0.1 - log entry 2 213",
                 "10.0.0.2 - log entry 133132" };
         String result = findTopIpaddress(input);
 
         if (result.equals("10.0.0.1")) {
             System.out.println("Test passed");
 
         } else {
             System.out.println("Test failed");
 
         }
 
 
     }
 
 }