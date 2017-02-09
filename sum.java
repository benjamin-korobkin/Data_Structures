/***********************************
* CSE2011 - Assignment 2
* File name: sum.java
* Author: Korobkin, Benjamin
* Email: bjkorb@yahoo.com
* CSE number: 212231189
************************************/


public class sum 
{


/*
 * EXHAUSTIVE ALGORITHM
 * Returns true if array A contains two elements whose sum is k.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( N^2 ).
 * You may add a brief explanation here if you wish.
 */

public static boolean sum_exh( int[] A, int n, int k)
{
	
   boolean isasum = false;
	for(int i = 0; i < n; i++)
	{
		for(int j = i+1; j<n;j++)
		{
			if(A[i] + A[j] == k)
			{
				isasum = true;
			}
		}
	}
   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.
	return isasum;
}  // end sum_exh





/*
 * RECURSIVE ALGORITHM
 * Returns true if array A contains two elements whose sum is k.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( N ).
 * You may add a brief explanation here if you wish.
 */

public static boolean sum_rec( int[] A, int n, int k)
{
	int j = A.length - 1;
	int i = 0;
	return sum_rec1(A, n, k, i, j);
   
	
}  
private static boolean sum_rec1(int[] A, int n, int k , int i, int j)
{
	boolean isasum = false;
	
	if(i != j)
	{
		if(A[i] + A[j] == k)
		{
			isasum = true;
		}
		else if(A[i] + A[j] > k)
		{
			j--;
			return sum_rec1(A, n, k, i, j);
		}
		else if(A[i] + A[j] < k)
		{
			i++;
			return sum_rec1(A, n , k, i, j);
		}
	}
		return isasum;
	
}
}

 // end class
