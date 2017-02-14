package clrs;

import java.util.Scanner;

public class LongestPalindrome {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String val = in.nextLine();
		int len = val.length();

		int[][] table = new int[len][len];

		for (int j = 0; j < table.length; j++) {
			table[j][j] = 1;
		}

		for (int window = 2; window <= len; window++) {
			for (int i = 0; i < len - window + 1; i++) {
				int j = i + window - 1;
				int tableCellValue = 0;
				if (val.charAt(i) == val.charAt(j) && window == 2) {
					tableCellValue = 2;
				} else if (val.charAt(i) == val.charAt(j)) {
					tableCellValue = 2 + table[i + 1][j - 1];

				} else {
					tableCellValue = Math.max(table[i][j - 1], table[i + 1][j]);
				}
				table[i][j] = tableCellValue;

			}
		}

		System.out.println(table[0][len - 1]);
	}
}
