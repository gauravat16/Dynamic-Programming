package clrs;

public class LongestCommonSubsquence {

	static LCSReturnType lcsLength(String[] X, String[] Y) {
		int[][] table = new int[X.length + 1][Y.length + 1]; //Saves the length of LCS till now
		int[][] save = new int[X.length + 1][Y.length + 1];  //Saves the path 1-diagonal 2-left 3-top 

		for (int i = 0; i < table.length; i++) {
			table[i][0] = 0;
		}

		for (int i = 0; i < table[i].length; i++) {
			table[0][i] = 0;
		}
		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[i].length; j++) {
				
				if (X[i - 1].equals(Y[j - 1])) {                   //If the current values are same
					table[i][j] = table[i - 1][j - 1] + 1;         //We append this value to the old LCS ie. here the lengths
					save[i][j] = 1;                                //Saving state

				} else if (table[i][j - 1] > table[i - 1][j]) {    //If they don't match we take full X and Y-1
					table[i][j] = table[i][j - 1];                 //We retain the previous value
					save[i][j] = 2;                                //Saving state

				} else {
					table[i][j] = table[i - 1][j];                //If they don't match we take full Y and X-1	
					                                              //We retain the value we had at previous Char
					save[i][j] = 3;                               //Saving state

				}

			}

		}

		return new LCSReturnType(table, table[X.length - 1][Y.length - 1], save); //Returns an obj

	}

	public static void main(String[] args) {
		String[] X = { "A", "B", "C", "B", "D", "A", "B" };
		String[] Y = { "B", "D", "C", "A", "B", "A" };
		LCSReturnType returnType = lcsLength(X, Y);
		int len = returnType.len;
		int[][] table = returnType.table;
		int[][] save = returnType.save;

		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[i].length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println("");
		}

		System.out.println("\n");
		for (int i = 1; i < save.length; i++) {
			for (int j = 1; j < save[i].length; j++) {
				System.out.print(save[i][j] + " ");
			}
			System.out.println("");
		}

		printLCS(returnType.save, table, X, Y);

	}

	static void printLCS(int[][] save, int[][] table, String[] X, String[] Y) { //Prints the LCS by tracing the path
		String lcs = "";
		int rowMax = save.length;
		int lastPos = save[rowMax - 1][save[rowMax - 1].length - 1];
		int i = rowMax - 1, j = save[rowMax - 1].length - 1;
		while (lastPos != 0) {
			if (save[i][j] == 1) {
				lcs += X[i - 1];
				i--;
				j--;
			}

			if (save[i][j] == 2) {
				j--;
			}
			if (save[i][j] == 3) {
				i--;
			}

			lastPos = save[i][j];

		}

		System.out.println(lcs);

	}
}

//Return OBJ
class LCSReturnType {
	int[][] table;
	int[][] save;
	int len;

	public LCSReturnType(int[][] tableParam, int lenParam, int[][] saveParam) {
		table = tableParam;
		len = lenParam;
		save = saveParam;
	}
}
