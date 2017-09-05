package com.collections.exs;

import java.util.Enumeration;
import java.util.Vector;

public class VectorEx {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
		
		Enumeration<Integer> e = v.elements();

		while(e.hasMoreElements()) {
			System.out.print(e.nextElement() + " ");		
		}
	}

}
