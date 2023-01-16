import java.io.*;
import java.util.*;

//  Find the best average grade.
//  Given a list of student test scores
//  Each student may have more than one test score in the list.

// print student's avg which is highest amoung all students


class Best_Average_Grade
{
  	
	public static Integer bestAvgGrade(String[][] scores) {
		// write your code goes here
		if (scores == null || scores.length == 0) {
			return 0;
		}

		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		Integer highAvg = 0;
		for (int i = 0; i < scores.length; i++) {
			List<Integer> scoreList = new ArrayList<Integer>();
			if(scores[i][0]==null) {
				throw new IllegalArgumentException("mark should not be null");
			}
			scoreList = map.get(scores[i][0]);
			if (scoreList == null) {
				List<Integer> cScore = new ArrayList<Integer>();
				if(scores[i][1]==null) {
					throw new IllegalArgumentException("mark should not be null");
				}
				Integer newScore = Integer.valueOf(scores[i][1]);
				cScore.add(newScore);
				map.put(scores[i][0], cScore);
			} else {
				scoreList.add(Integer.valueOf(scores[i][1]));
				map.put(scores[i][0], scoreList);

			}

		}

		for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
			highAvg = Math.max(highAvg, calcAvg(entry.getValue()));
		}

		return highAvg;
	}

	private static Integer calcAvg(List<Integer> list) {
		Integer len = list.size();
		int sum = 0;
		for (int score : list) {
			sum += score;
		}
		int avg = sum / len;
		return avg;
	}


  public static boolean pass()
  {
    String[][] s1 = { { "Rohan", "84" },
               { "Sachin", "102" },
               { "Ishan", "55" },
               { "Sachin", "18" } };

    return bestAvgGrade(s1) == 84;
  }

  public static void main(String[] args)
  {
    if(pass())
    {
      System.out.println("Pass");
    }
    else
    {
      System.out.println("Some Fail");
    }
  }
}


