package practiceQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumRect {

	// Max sub-matrix in a 2-D matrix.
	// { 1, 2, -1,-4,-20},
	// {-8,-3,  4, 2,  1},
	// { 3, 8, 10, 1,  3},
	// {-4,-1,  1, 7, -6}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int row = Integer.parseInt(in[0]);
		int col = Integer.parseInt(in[1]);
		int[][] inArr = new int[row][col];
		for (int i = 0; i < row; i++) {
			String[] rowS = br.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				inArr[i][j] = Integer.parseInt(rowS[j]);
			}
		} 
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < col; i++) {
			int[] row_sum = new int[row];
			for (int j = i; j < col; j++) {
				for (int k = 0 ; k < row; k++) {
					row_sum[k] = inArr[k][j] + row_sum[k];
				}
				int max_curr = getMaxSum(row_sum);
				max = max > max_curr ? max : max_curr;
			}
		}
		System.out.println(max);
	}

	private static int getMaxSum(int[] row_sum) {
		int len = row_sum.length;
		int max = Integer.MIN_VALUE;
		int prev = 0;
		for (int i = 0; i < len; i++) {
			int curr = row_sum[i] + prev;
			if (curr < 0) {
				curr = 0;
			}
			prev = curr;
			max = max > prev ? max : prev;
		}
		return max;
	}
}
