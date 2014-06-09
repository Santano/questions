package practiceQuestions;

import java.io.*;

public class TrappingRainWater {
	
	public static void main(String[] args) throws IOException {
		int[] temp = {5,2,1,2,1,5};
		System.out.print(trap3(temp));
	}
	
	public static int trap3(int[] a) {
		int l = a.length;
		int[] before = new int[l];
		int[] after = new int[l];
		int max = 0;
		for (int i = 0 ; i < l ; i++) {
			before[i] = max;
			max = max > a[i] ? max : a[i];
		}
		max = 0;
		for (int i = l-1 ; i >= 0 ; i--) {
			after[i] = max;
			max = max > a[i] ? max : a[i];
		}
		int sum = 0;
		for (int i = 0 ; i < l; i++) {
			int lv = after[i] > before[i] ? before[i] : after[i];
			if (a[i] >= lv)
				continue;
			sum = sum + lv - a[i];
			
		}
		return sum;
	}
}
