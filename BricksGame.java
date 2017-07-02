package clrs;

import java.util.Scanner;

public class BricksGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		for(int i= 1;i<=cases;i++){
			int len = Integer.parseInt(in.nextLine());
			long[] preSums = new long[len+1];
			long[] brickVals = new long[len+1];
			long[] DP = new long[len+1];
			preSums[0]=0;
			DP[0] = 0;
			
			String[] strVals = in.nextLine().split(" ");
			int index=0;
			for(int j=len;j>0;j--){
				brickVals[j] = Long.parseLong(strVals[index]);
				index++;
				
			}
			
			for(int j=1;j<=len;j++){
				preSums[j] = preSums[j-1]+ brickVals[j];

			}
			
			DP[1]=brickVals[1];
			DP[2]=DP[1]+brickVals[2];
			DP[3]=DP[2]+brickVals[3];
			
			for(int k=4;k<brickVals.length;k++){
				DP[k] = Math.max(preSums[k-1]-DP[k-1]+brickVals[k], (long) -1);
				DP[k] = Math.max(preSums[k-2]-DP[k-2]+brickVals[k]+brickVals[k-1], DP[k]);
				DP[k] = Math.max(preSums[k-3]-DP[k-3]+brickVals[k]+brickVals[k-1]+brickVals[k-2], DP[k]);
			}
			
			System.out.println(DP[len]);


			
			

		}

	}

}
