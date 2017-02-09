package Asg03;

/***********************************
* EECS2011 - Assignment 3
* File name: ArrayDeque.java
* Author: Karon, Joshua
* Email: joshkaron@gmail.com
* CSE number: 213374137
************************************/


public class ArrayDeque
{
   public static final int INIT_CAPACITY = 8;	// initial array capacity
   protected int capacity;  // current capacity of the array
   protected int front;     // index of the front element
   protected int rear;      // index of the rear element
   protected int[] A;	    // array deque

   public ArrayDeque( )      // constructor method
   {
      A = new int[ INIT_CAPACITY ];
      capacity = INIT_CAPACITY;
      front = rear = 0;
   }


    /**
     * Display the content of the deque
     * 
     */
    public void printDeque( )
    {
      for ( int i = front; i != rear; i = (i+1) % capacity )
	System.out.print( A[i] + " " );
      System.out.println();
    }


    /**
     * Display the content of the whole array
     *
     */
    public void printArray( )
    {
	for ( int i = 0; i < capacity; i++ )
	   System.out.print( A[i] + " " );
	System.out.println();
    }


   // ***************************************
   // DO NOT MODIFY THE CODE ABOVE THIS LINE.
   // ADD YOUR CODE BELOW THIS LINE.
   //
   // ***************************************

   /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
    	if(rear > front)
    		return rear - front;
    	else
    		return capacity - (front - rear);
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
    	if(front==rear)
    		return true;
    	else
    		return false;
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst() throws EmptyDequeException
    {
      return A[front];      
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {  
      return A[(rear-1+capacity)%capacity];        
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
    	front = (front - 1 + capacity) % capacity; 
    	
    	if(front==rear)
    		extend();
    	
    	A[front] = e;
    }


    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    { 
    	A[rear] = e;
    	rear = (rear + 1) % capacity;
    	
    	if(front== rear)
    		extend();
    }


    /**
     * Removes and returns the first element of the deque
     * 
     */
    public int removeFirst( ) throws EmptyDequeException
    {
    	int x = A[front];
    	A[front]=0;
    	front = (front + 1) % capacity;
    	
    	shrink();
        return x;   
    }


    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast( ) throws EmptyDequeException
    {
      rear = (rear - 1 + capacity) % capacity;
      int x = A[rear];
      A[rear] = 0;
      
  	  shrink();
      return x;  
    }
    
    /**
     * when Array A is full, copies to an array of double capacity
     * 
     */
    public void extend()
    {
    	int[] B = new int[capacity*2];
    	
    	for(int i=0; i < capacity ;i++)
    	{
    		B[i] = A[(front+i)%capacity];
    	}
    	
    	A = B;
    	front = 0;
    	rear = capacity;
    	capacity = capacity * 2;
    }
    
    /**
     * when the array A is 3/4 empty copies the array to an array of half the size 
     * 
     */
    public void shrink()
    {
    	if(size()*4 == capacity && capacity/2 >= INIT_CAPACITY)
    	{
    		
    		
    		int[] C = new int[capacity/2];
        	
        	for(int i=0; i < capacity/4 ; i++)
        	{
        		C[i] = A[(front+i)%capacity];
        	}
        	A = C;
        	front = 0;
        	rear = capacity/4;
        	capacity = capacity / 2;
        	
        	
    	}
    }

}  // end class
