package practiceQuestions;

import java.io.*;

public class KnapSack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] w = br.readLine().split(" ");
		String[] v = br.readLine().split(" ");
		int max_w = Integer.parseInt(br.readLine());
		int len = w.length;
		int[][] r = new int[len][max_w+1];
		for (int i = 0 ; i < len ; i++) {
			for (int j = 0 ; j <= max_w ; j++) {
				int v1 = 0;
				int v2 = 0;
				int currW = Integer.parseInt(w[i]);
				int currV = Integer.parseInt(v[i]);
				if (currW <=  j)
					v1 = currV;
				try {
					v1 = v1 + r[i-1][j-currW];
				}
				catch (Exception e) {}
				try {
					v2 = r[i-1][j];
				}
				catch (Exception e) {}
				r[i][j] = v1 > v2 ? v1 : v2;
			}
		}
		System.out.println(r[len-1][max_w]);
	}
}