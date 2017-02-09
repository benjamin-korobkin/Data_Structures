/***********************************
* CSE2011 - Assignment 2
* File name: kthsmallest.java
* Author: Last name, first name
* Email: Your email address
* CSE number: Your cse number
************************************/


public class kthsmallest {

public static final int MaxSize = 500;

/*
 * Return the value of the kth smallest element of array A.
 * n is the number of elements A contains, and k <= n.
 * The running time of your algorithm must be O(n).
 *
 */

public static int find_kth_smallest( int[] A, int n, int k )
{

   // COMPLETE THIS METHOD.
	return find_kth_smallest1(A, 0, n-1, k);
	
	
   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.


   /* Note 1:
    * During the partitioning process, array elements may be swapped and moved around.
    * DO NOT modify the content of array A.  Copy it to a temporary array B and work on B instead.
    */

   /* Note 2:
    * DO NOT SORT THE WHOLE ARRAY and then return B[k-1].  That would take O(nlogn) time.
    * If you do that, your program will get zero point.*/
}  // end find_kth_smallest

private static int find_kth_smallest1(int[] A, int i, int j, int k)
{
	int pivot = partition(A, i, j);

	if(pivot-i == k-1)
	{
		return A[pivot];
	}
	else if(pivot - i > k-1)
	{
		return find_kth_smallest1(A, i, pivot-1, k);
	}
	else
	{
		return find_kth_smallest1(A, pivot + 1, j, k-pivot+i-1);
	}
	
}
private static int partition(int[] A, int i, int j) {
int pivot = A[j];
	
	int start = i;
	int end = j - 1;
	
	
	while(i < j)
	{
//		if (i > j)
//		{
//			break;
//		}
		if(A[i] >= pivot)
		{
			i++;
		}
		else
		{
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
	}
	
	int temp = A[i];
	A[i] = pivot;
	pivot = temp;
	
	return pivot;
}
} // end class


