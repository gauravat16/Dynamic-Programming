package clrs;

import java.util.Scanner;

public class RodCut {
	static int[] profArr;
	static int[] memoized;
	static int[] save;
	static int rodLen;

	static int cut(int length) {
		int profit;
		if (memoized[length] >= 0) {
			return memoized[length];
		}

		if (length == 0) {
			profit = 0;
		} else {
			profit = Integer.MIN_VALUE;
		}

		for (int j = 1; j <= length; j++) {
			profit = Math.max(profit, profArr[j] + cut(length - j));
		}

		memoized[length] = profit;

		return profit;

	}

	static int extendedCut(int length) {
		int profit;

		if (memoized[length] >= 0) {
			return memoized[length];
		}

		if (length == 0) {
			profit = 0;
		} else {
			profit = Integer.MIN_VALUE;
		}

		for (int j = 1; j <= length; j++) {
			if (profit < profArr[j] + extendedCut(length - j)) {
				profit = profArr[j] + extendedCut(length - j);
				save[j] = profit;
			}

		}

		memoized[length] = profit;

		return profit;

	}

	static int topDownCut(int length) {
		int profit = 0;
		for (int i = 1; i < rodLen + 1; i++) {

			profit = Integer.MIN_VALUE;
			for (int j = 1; j <= i; j++) {
				profit = Math.max(profit, profArr[j] + memoized[i - j]);
			}
		}

		return profit;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		rodLen = Integer.parseInt(in.nextLine());
		memoized = new int[rodLen + 1];

		profArr = new int[] { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

		for (int i = 0; i < rodLen + 1; i++) {
			memoized[i] = Integer.MIN_VALUE;
		}

		save = new int[rodLen + 1];

		// System.out.println(cut(rodLen));
		// System.out.println(topDownCut(rodLen));
		extendedCut(rodLen);
		for (int j : save) {
			System.out.println(j);
		}
		in.close();

	}

	static int[] stringToIntArr(String[] input) {
		int[] opArr = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			opArr[i] = Integer.parseInt(input[i]);
		}
		return opArr;

	}

}
