package practiceQuestions;

public class CatalanNumber {

	public static void main(String[] args) {
		System.out.println(numTrees(1));
		System.out.println(numTrees(2));
		System.out.println(numTrees(3));
	}

	public static int numTrees(int n) {
		if (n == 0)
			return 1;
		double result = numTrees(n - 1) * ( (double) 2 * (2 * n - 1) / (n + 1));
		return (int) result;
	}
}
