package practiceQuestions;

import java.io.*;

public class LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		int len1 = s1.length;
		int len2 = s2.length;
		int max_all = Integer.MIN_VALUE;
		int[][] lcs = new int[len1][len2];
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				int curr = 0;
				int max = 0;
				if (s1[i] == s2[j]) {
					curr = 1;
					try {
						max = lcs[i - 1][j - 1];
					} catch (Exception e) {
					}
				} else {
					int v1 = 0;
					int v2 = 0;
					try {
						v1 = lcs[i - 1][j];
					} catch (Exception e) {
					}
					try {
						v2 = lcs[i][j - 1];
					} catch (Exception e) {
					}
					max = v1 > v2 ? v1 : v2;
				}
				lcs[i][j] = curr + max;
				max_all = max_all > lcs[i][j] ? max_all : lcs[i][j];
			}
		}
		System.out.println(max_all);
	}
}