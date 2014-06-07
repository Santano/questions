package practiceQuestions;

public class InterLeavingStrings {

	public static void main(String[] args) {

	}

	// i, l1, s1 (combined)
	// j, l2, s2
	// k, l3, s3
	public boolean isInterleave(String s3, String s2, String s1) {
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
//		char[] c3 = s3.toCharArray();
		Boolean[][][] result = new Boolean[l1][l2][l3];
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				for (int k = 0; k < l3; k++) {
					if (i > k + j) {
						result[i][j][k] = false;
						continue;
					}
					if (k == 0) {
						if (c1[i] == c2[j]) {
							try {
								result[i - 1][j - 1][k] = false;
							} catch (Exception e) {
							}
						}
					}
				}
			}
		}

		return true;
	}

}
