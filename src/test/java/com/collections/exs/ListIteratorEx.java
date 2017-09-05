package com.collections.exs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListIteratorEx {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		list.add("Five");
		
		Iterator<String> itr = list.iterator();
		
		System.out.println("Using Iterator - Forward Only Traverse");
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		ListIterator<String> litr = list.listIterator(); 
		System.out.println("\nUsing ListIterator - Forward Traverse");
		while(litr.hasNext()) {
			System.out.print(litr.next() + " ");
		}
		System.out.println("\nUsing ListIterator - Backward Traverse");
		while(litr.hasPrevious()) {
			System.out.print(litr.previous() + " ");
		}

	}

}
