package clrs;

public class MatrixChainMultiplication {

	static int matrixChainMulp(int[] inp) {
		int size = inp.length; // We take the size of the input ie. we include
				      // the 0th col and row but we wont use it.

		int[][] scalarMulpMatrix = new int[size][size]; // 0,1,2,3 (0th wont be used)

		int[][] save = new int[size][size];
		for (int i = 1; i < size; i++) {
			scalarMulpMatrix[i][i] = 0; // Putting all zeros in diagonals ie. no
										// multiplicaton in case of that matrix
										// itself ie length = 1
		}

		for (int l = 2; l < size; l++) { // Here we iterate between max length of chain 2 -> as 1

			for (int i = 1; i < size - l + 1; i++) { // now we select which  matrix we want to  start with
														
														
				int j = i + l - 1; // here we select the matrix we want to
									// multiply with - we add l or length
									// because it moves as a window of l length
									// (i-->j)

				scalarMulpMatrix[i][j] = Integer.MAX_VALUE; // Setting current
															// value to infinity

				for (int k = i; k <= j - 1; k++) { // Traversing through all
													// possible division points
					int mulps = scalarMulpMatrix[i][k] + scalarMulpMatrix[k + 1][j] + inp[i - 1] * inp[k] * inp[j]; // Divided on k,so. i->k,k+1->j, + cost of multiplying these two
																								 
																													
					if (mulps < scalarMulpMatrix[i][j]) {
						scalarMulpMatrix[i][j] = mulps;
						save[i][j] = k;
					}
				}

			}
		}

		// return scalarMulpMatrix[1][size - 1]; // We return the value in table
		// 1,last col. why? its first
		// matrix to last matrix scalar
		// multiplication sum

		return scalarMulpMatrix[1][size - 1];

	}

	public static void main(String[] args) {
		int[] input = { 30, 35, 15, 5, 10, 20, 25 };

		System.out.println(matrixChainMulp(input));
	}

}
