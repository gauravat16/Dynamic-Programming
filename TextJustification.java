package clrs;

public class TextJustification {

	static int M = 6;
	static String[] line = "aaa bb cc ddddd".split(" "); 
	static int[] wordLenArr = new int[line.length + 1];
	static int[][] cost = new int[line.length + 1][line.length + 1];
	static int[] DP = new int[line.length + 1];
	static int[] track = new int[line.length + 1];

	static void createCostTable() {
		for (int i = 1; i < cost.length; i++) {
			for (int j = i; j < cost.length; j++) {
				int val = M - calcSubstringLength(i, j);
				if (val >= 0) {
					cost[i][j] = val * val * val;

				} else {
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
		}
	}

	static int calcSubstringLength(int i, int j) {
		int len = 0;
		for (int k = i; k <= j; k++) {
			len += wordLenArr[k];
		}
		return len;
	}

	static void findWordLengths() {
		int index = 1;
		for (String s : line) {
			wordLenArr[index] = s.length();
			index++;
		}
	}

	static void JustifyText() {
		DP[0] = 0;
		for (int i = 1; i< DP.length; i++) {
			DP[i] = Integer.MAX_VALUE;
			for (int j = 1; j <=i; j++) {
				if (DP[j - 1] + cost[j][i] < DP[i]) {
					DP[i] = DP[j - 1] + cost[j][i];
					track[i] = j;
				}
			}
		}

	}
	
	

	public static void main(String[] args) {
		findWordLengths();
		createCostTable();
		JustifyText();
		for (int i = 1; i < track.length; i++) {
			System.out.println(track[i]);
		}

	}

}
