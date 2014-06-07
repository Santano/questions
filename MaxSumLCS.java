package practiceQuestions;

import java.io.*;

public class MaxSumLCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		String[] in = br.readLine().split(" ");
		int[] r = new int[l];
		int max_all = 0;
		for (int i = 0; i < l; i++) {
			int max = Integer.MIN_VALUE;
			int currNum = Integer.parseInt(in[i]);
			for (int j = 0; j < i; j++) {
				int num = Integer.parseInt(in[j]);
				if (num <= currNum) {
					max = max > r[j] ? max : r[j];
				}
			}
			if (max < 0)
				max = 0;
			max = max + currNum;
			r[i] = max;
			max_all = max_all > max ? max_all : max;
		}
		System.out.println(max_all);
	}
}