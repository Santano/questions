package practiceQuestions;

import java.util.HashMap;

public class LCSNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] test = { -1, 0 , 2, 1, 3,1 , 3 };
		System.out.println(longestConsecutive(test));
	}

	public static int longestConsecutive(int[] num) {
		HashMap<Integer, Boolean> temp = new HashMap<Integer, Boolean>();
		for (int i = 0 ; i < num.length ; i++) {
			temp.put(num[i], false);
		}
		int len = 0;
		for (int i = 0 ; i < num.length ; i++) {
			int curr = 0;
			if (temp.get(num[i]))
				continue;
			int numC = num[i] + 1;
			curr = 1;
			while (temp.containsKey(numC)){
				temp.put(numC, true);
				curr++;
				numC = numC + 1;
			}
			numC = num[i] - 1;
			while (temp.containsKey(numC)){
				temp.put(numC, true);
				curr++;
				numC = numC - 1;
			}
			len = curr > len ? curr : len;
		}
		return len;
	}

}
