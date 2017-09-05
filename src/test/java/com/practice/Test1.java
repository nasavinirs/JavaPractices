package com.practice;

import java.util.*;

public class Test1 {

	public static void main(String args[])
	{
		NavigableSet<Integer> ns = new TreeSet<Integer>();
		ns.add(10);
		ns.add(30);
		ns.add(20);
		ns.add(25);
		ns.add(20);
		
		System.out.println(ns.higher(26));
		System.out.println(ns.lower(20));
		System.out.println(ns.floor(20));
		
	}
	


}



