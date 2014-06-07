package practiceQuestions;

import java.io.*;

public class CoinProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] coins = br.readLine().split(" ");
		int num_coin = coins.length;
		int[][] result = new int[n + 1][num_coin];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i == 0) {
					result[i][j] = 1;
				} else {
					int v1 = 0;
					int v2 = 0;
					try {
						v1 = result[i - Integer.parseInt(coins[j])][j];
					} catch (Exception e) {
					}
					try {
						v2 = result[i][j - 1];
					} catch (Exception e) {
					}
					result[i][j] = v1 + v2;
				}
			}
		}
		System.out.println(result[n][num_coin - 1]);
	}
}