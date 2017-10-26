package com.practice;

import java.util.ArrayList;
import java.util.List;

public class FailFastExample1 {
	public static void main(String args[])
	{
		List<Integer> arr = new ArrayList<Integer>();
		
		System.out.println(arr.size());
		arr.add(1);
		arr.add(2);
		arr.add(3);
		System.out.println(arr.size());
		arr.add(3);
	}
}
