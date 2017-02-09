/***********************************
* CSE2011 - Assignment 2
* File name: match.java
* Author: Korobkin, Benjamin
* Email: bjkorb@yahoo.com
* CSE number: 212231189
************************************/


public class match {

/*
 * EXHAUSTIVE ALGORITHM
 * Returns index i if array A contains an element A[i] such that A[i] = i.
 * If there exist many of such elements, return the index of any one of them.
 * Returns -1 if there exists no element A[i] such that A[i] == i.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( N ).
 * You may add a brief explanation here if you wish.
 */


	public static int match_exh( int[] A, int n) 
	{

		// COMPLETE THIS METHOD.
		
		
		for(int i = 0; i < n; i++)
		{
			//int i = n;
			if(A[i] == i)
			{
				return i;
			}
		}
		
		return -1;
		
		// You may define local variables inside this method.

		// You may add your own methods/subroutines to this file.
		

	} // end match_exh




/*
 * DIVIDE-AND-CONQUER ALGORITHM
 * Returns index i if array A contains an element A[i] such that A[i] = i.
 * If there exist many of such elements, return the index of any one of them.
 * Returns -1 if there exists no element A[i] such that A[i] == i.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( logN ).
 * You may add a brief explanation here if you wish.
 */

	public static int match_dac(int[] A, int n)
	{		
		// COMPLETE THIS METHOD.
		
		// You may define local variables inside this method.

		// You may add your own methods/subroutines to this file.
		return match_dac1(A,0,n - 1);
	}  // end match_dac
	private static int match_dac1(int[] A, int l, int r)
	{
		if(l == r)
		{
			return -1;
		}
		
		int pivot = (l + r)/2;
		
		if (A[pivot] == pivot)
		{
			return pivot;
		}
		
		if(A[pivot] > pivot) // say there are 5 elements. the 3rd element is equal to 4. So now we know that the bigger half doesn't contain a match.
		{
			return match_dac1(A,l,pivot - 1);
		}
		
		if(A[pivot] < pivot) // so lets say the 3rd element (out of 5) is 2 so you know that the lesser half doesn't match.
		{

			return match_dac1(A,pivot + 1,r);
		}

			
		return -1;
		
	}

} // end class