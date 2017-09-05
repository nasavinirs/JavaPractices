package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

public class ArrayListAddEx {

	public static void main(String args[])
	{
		Integer arr[] = {1, 2, 3, 4 ,5};
		
		// Using Normal way of ArrayList 
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		arrlist.add(1);
		arrlist.add(2);
		arrlist.add(3);
		arrlist.add(4);
		arrlist.add(5);
		
		// Converting array to ArrayList with Arrays.asList()
		//ArrayList<Integer> alist = new ArrayList<Integer>(Arrays.asList(arr));
		
		// Using Collections.nCopies()
		//ArrayList<String> alist = new ArrayList<String>(Collections.nCopies(10, "Testing"));
		
		// Using Anonymous inner class method
		/*ArrayList<Integer> alist = new ArrayList<Integer>(){{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
		}};*/
		
		System.out.println(arrlist);
		
		/* For Loop for iterating ArrayList */
	      System.out.println("For Loop");
	      for (int counter = 0; counter < arrlist.size(); counter++) { 		      
	          System.out.println(arrlist.get(counter)); 		
	      }   		

	      /* Advanced For Loop*/ 		
	      System.out.println("Advanced For Loop"); 		
	      for (Integer num : arrlist) { 		      
	           System.out.println(num); 		
	      }

	      /* While Loop for iterating ArrayList*/ 		
	      System.out.println("While Loop"); 		
	      int count = 0; 		
	      while (arrlist.size() > count) {
		 System.out.println(arrlist.get(count));
	         count++;
	      }

	      /*Looping Array List using Iterator*/
	      System.out.println("Iterator");
	      Iterator iter = arrlist.iterator();
	      while (iter.hasNext()) {
	         System.out.println(iter.next());
	      }
	      
	      // Get the Enumeration object
	      Enumeration<Integer> e = Collections.enumeration(arrlist);
	 
	      // Enumerate through the ArrayList elements
	      System.out.println("ArrayList elements: ");
	      while(e.hasMoreElements())
	      System.out.println(e.nextElement());
	      
      
	}
}
