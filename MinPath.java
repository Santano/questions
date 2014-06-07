package practiceQuestions;

import java.io.*;

public class MinPath {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int row = Integer.parseInt(br.readLine());
		int col = Integer.parseInt(br.readLine());
		int[][] input = new int[row][col];
		int[][] minPath = new int[row][col];
		for (int i = 0; i < row; i++) {
			String[] in = br.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				input[i][j] = Integer.parseInt(in[j]);
				if (i == 0 && j == 0) {
					minPath[i][j] = input[i][j];
				} else {
					int v1 = Integer.MAX_VALUE;
					int v2 = Integer.MAX_VALUE;
					int v3 = Integer.MAX_VALUE;
					try {
						v1 = minPath[i - 1][j - 1];
					} catch (Exception e) {
					}
					try {
						v2 = minPath[i - 1][j];
					} catch (Exception e) {
					}
					try {
						v3 = minPath[i][j - 1];
					} catch (Exception e) {
					}
					minPath[i][j] = input[i][j] + min_value(v1, v2, v3);
				}
			}
		}
		int r = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		System.out.println(minPath[r][c]);
	}

	public static int min_value(int a, int b, int c) {
		int min = a < b ? a : b;
		return min < c ? min : c;
	}
}