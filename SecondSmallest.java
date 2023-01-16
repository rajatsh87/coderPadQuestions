import java.util.Arrays;

public class SecondSmallest {
	/**
	 * int secondSmallest(int[] x)
	 */
	public static int secondSmallest(int[] x) {
		Arrays.sort(x);
		if(x.length>1)
			return x[1];
		return x[0];
	}

	public static void main(String args[]) {

		int[] a = { 0 };
		int[] b = { 0, 1 };

		boolean result = true;
		result &= secondSmallest(a) == 0;
		result &= secondSmallest(b) == 1;

		if (result) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

	}
}