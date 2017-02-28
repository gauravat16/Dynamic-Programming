public class EditDistance {
	static String s1 = "abcdef";
	static String s2 = "azced";
	static int[][] dp = new int[s2.length() + 1][s1.length() + 1];

	public static void main(String[] args) {

		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
		}

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}

		visulaizeMatrix(dp);

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				System.out.println("(" + i + "," + j + ")");
				if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}

			}

		}

		visulaizeMatrix(dp);

	}

	static void visulaizeMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println("");
		}

	}
}
