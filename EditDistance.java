package practiceQuestions;

import java.io.*;

public class EditDistance {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		int l1 = s1.length;
		int l2 = s2.length;
		// int max_distance = Integer.MIN_VALUE;
		int[][] edit_arr = new int[l1][l2];
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				int curr = 0;
				int v1 = Integer.MAX_VALUE;
				int v2 = Integer.MAX_VALUE;
				int v3 = Integer.MAX_VALUE;
				if (s1[i] != s2[j]) {
					curr = curr + 1;
				}
				try {
					v1 = edit_arr[i - 1][j - 1] + curr;
				} catch (Exception e) {
				}
				try {
					v2 = edit_arr[i - 1][j] + 1;
				} catch (Exception e) {
				}
				try {
					v3 = edit_arr[i][j - 1] + 1;
				} catch (Exception e) {
				}
				edit_arr[i][j] = min_value(v1, v2, v3);
				if (i == 0 && j == 0)
					edit_arr[i][j] = curr;
			}
		}
		System.out.println(edit_arr[l1 - 1][l2 - 1]);
	}

	public static int min_value(int a, int b, int c) {
		int min = a < b ? a : b;
		return min < c ? min : c;
	}
}