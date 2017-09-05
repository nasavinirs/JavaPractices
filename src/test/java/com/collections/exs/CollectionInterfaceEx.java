package com.collections.exs;

import java.util.ArrayList;
import java.util.List;

public class CollectionInterfaceEx {

	public static void main(String[] args) {

		List<Integer> aList = new ArrayList<Integer>();
	
		aList.add(1);
		aList.add(2);
		aList.add(3);
		aList.add(4);
		aList.add(5);

		List<Integer> bList = new ArrayList<Integer>(aList.subList(1, 3));

		System.out.println("A List Elements : " + aList);
		System.out.println("B List Elements : " + bList);
		
		if(aList.containsAll(bList)) {
			System.out.println("B List elements are present in A List");
		}
		else {
			System.out.println("B List elements are not present in A List");
		}			
	}
}
