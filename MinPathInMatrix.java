package practiceQuestions;

public class MinPathInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] temp = {{1,2},{1,1}};
		System.out.print(minPathSum(temp));
	}
	
	public static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] s = new int[r][c];
        for (int i = 0 ; i < r ; i++) {
            for (int j = 0 ; j < c ; j++) {
                int v1 = Integer.MAX_VALUE;
                int v2 = Integer.MAX_VALUE;
                int max_v = 0;
                try {
                    v1 = s[i-1][j];
                }
                catch(Exception e) {}
                try {
                    v2 = s[i][j-1];
                }
                catch(Exception e) {}
                max_v = v1 < v2 ? v1 : v2 ;
                if (i == 0 && j == 0)
                	max_v = 0;
                s[i][j] = grid[i][j] + max_v;
            }
        }
        return s[r-1][c-1];
    }
}
