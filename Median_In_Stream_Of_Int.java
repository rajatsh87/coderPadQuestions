import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/* 
   Given that integers are read from a data stream. Find median of elements read so 
   for in an efficient way. For simplicity assume, there are no duplicates. For example, 
   let us consider the stream 5, 15, 1, 3 � 

   After reading 1st element of stream - 5 -> median - 5
   After reading 2nd element of stream - 5, 15 -> median - 10
   After reading 3rd element of stream - 5, 15, 1 -> median - 5
   After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...  
 */

public class Median_In_Stream_Of_Int {

	public static void printMedian(int arr[]) {
		PriorityQueue<Integer> pqMax = new PriorityQueue<>((a, b) -> -1 * (a - b));
		PriorityQueue<Integer> pqMin = new PriorityQueue<>((a, b) -> a - b);
		int medium = 0;
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (pqMax.peek() == null) {
				pqMax.add(arr[i]);
				medium = arr[i];
			} else if (pqMax.size() == pqMin.size()) {
				if (arr[i] > pqMin.peek()) {
					int val = pqMin.poll();
					pqMax.add(val);
					pqMin.add(arr[i]);
				} else {
					pqMax.add(arr[i]);
				}
				medium = pqMax.peek();
			} else if (pqMin.size() < pqMax.size()) {
				if (pqMax.peek() > arr[i]) {
					int val = pqMax.poll();
					pqMin.add(val);
					pqMax.add(arr[i]);
				} else {
					pqMin.add(arr[i]);
				}
				medium = (pqMax.peek() + pqMin.peek()) / 2;
			}
			temp.add(arr[i]);
			Collections.sort(temp);
			System.out.println(temp.toString());
			System.out.println(medium);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
		printMedian(arr);
	}

}
