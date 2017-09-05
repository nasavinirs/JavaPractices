package com.collections.exs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSortEx {
	public static void main(String args[]) {
	
		List<String> list = new ArrayList<String>();
		list.add("Vishnu");
		list.add("Raman");
		list.add("Krishnan");
		list.add("Srinivasan");
		
		System.out.println("Before Sorting");
		
		for(String str : list) {
			System.out.print(str + " ");
		}
		
		Collections.sort(list);
		
		System.out.println("\nAfter Sorting");
		for(String str : list) {
			System.out.print(str + " ");
		}
	}
}
