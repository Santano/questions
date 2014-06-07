package practiceQuestions;

import java.io.*;

public class RodSplit {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String[] l = br.readLine().split(" ");
		String[] p = br.readLine().split(" ");
		int[][] result = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				// not taking current i
				int v1 = 0;
				try {
					v1 = result[i - 1][j];
				} catch (Exception e) {
				}
				// taking it
				int v2 = 0;
				if (j >= i)
					v2 = Integer.parseInt(p[i]);
				try {
					v2 = v2 + result[i][j - Integer.parseInt(l[i])];
				} catch (Exception e) {
				}
				result[i][j] = v1 > v2 ? v1 : v2;
			}
		}
		System.out.println(result[len - 1][len - 1]);
	}
}