/***********************************
* CSE2011 - Assignment 2 
* File name: symm.java
* Author: Korobkin, Benjamin
* Email: bjkorb@yahoo.com
* CSE number: 212231189
************************************/

public class symm
{


/* 
 * Returns true if array A is symmetric.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( N/2 ).
 * You may add a brief explanation here if you wish.
 */

	public static boolean symmetric( int[] A, int n )
	{
		// COMPLETE THIS METHOD.
		if (A.length == 0 || A.length == 1)
		{
			return true;
		}
		return symmetric1(A, n, 0);
		// You may define local variables inside this method.
		
		// You may add your own methods/subroutines to this file.

	}  // end symmetric
	private static boolean symmetric1(int[] A, int n, int i)
{
	boolean isitsymm = false;
	if(A[i] == A[n-1-i])
	{
		isitsymm = true;
	}
	if(i <= n/2)
	{
		i++;
		return symmetric1(A, n, i);
	}
	return isitsymm;
}
	

}  // end class

