import java.util.*;;

/*
 * 
 *     {{2,4},{5,7},{6,9},{9,11},{12,14}}
 *     {{2,4},{5,11},{12,14}}
 * 
 */

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> val = new ArrayList<>();
        val.add(new ArrayList<>(Arrays.asList(2, 4)));
        val.add(new ArrayList<>(Arrays.asList(5, 6)));
        val.add(new ArrayList<>(Arrays.asList(6, 9)));
        val.add(new ArrayList<>(Arrays.asList(9, 11)));
        val.add(new ArrayList<>(Arrays.asList(12, 14)));

        ArrayList<ArrayList<Integer>> ans = function(val);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i).toString());
        }
    }

    public static ArrayList<ArrayList<Integer>> function(ArrayList<ArrayList<Integer>> list) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i).get(0);
            int end = list.get(i).get(1);
            // int curr=i+1;
            while (i + 1 < list.size() && list.get(i + 1).get(0) <= list.get(i).get(1)) {
                start = Math.min(list.get(i + 1).get(0), start);
                end = Math.max(list.get(i + 1).get(1), end);
                i++;
            }
            ArrayList<Integer> val = new ArrayList<>();
            val.add(start);
            val.add(end);
            ans.add(val);
        }

        return ans;
    }
}
