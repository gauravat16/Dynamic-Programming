

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class OptimalSearchTree
{
	static int n=5;
	static double[][] e = new double[n+1][n+1];
	static double[][] w = new double[n+1][n+1];
	static double[][] root = new double[n+1][n+1];

	
	
// 	The first index needs to run to nC1 rather than n because
// in order to have a subtree containing only the dummy key dn, we need to compute
// and store e C 1; n. The second index needs to start from 0 because in order to
// have a subtree containing only the dummy key d0, we need to compute and store


 static String optimalBST(double[] p,double[] q){
 	
 	for(int m=1;m<=n;m++){
 		e[m][m-1] = q[m-1];
 		w[m][m-1] = q[m-1];
 		 	    System.out.println(m+","+(m-1));

 		 	}
 		 	
 	for(int l=1;l<=n;l++){
 		for(int i=1;i<=(n-l+1);i++){
 		   System.out.println(i);

 			int j=i+l-1;

 			e[i][j] = Integer.MAX_VALUE;
 			w[i][j] = w[i][j-1]+p[j]+q[j];
 			double t;
 			for(int r=i;i<=j;i++){
 				t=e[i][r-1]+e[r+1][j]+w[i][j];
 				if(t<e[i][j]){
 					e[i][j]=t;
 					root[i][j] = r;
 				}
 			}
 		}
 	}
 	return e[n+1][n]+" ";
 }

	
	public static void main (String[] args) throws java.lang.Exception
	{
		n=5;
		 double[] p = {0.15,0.1,0.05,0.10,0.20};
		
		double[] q = {0.05,0.10,0.05,0.05,0.05,0.10};
		System.out.println(optimalBST(p,q));
		
	}
}
