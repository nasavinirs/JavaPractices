package com.practice;

import java.util.function.Function;

public class FunctionalProgramExample {

	public static void main(String[] args) {		
		Function<Integer,Integer> add1 = x -> x + 1;
		Function<String,Integer> atoi = s -> Integer.valueOf(s);
		Integer two = add1.apply(1);
		Function<Integer,Integer> add2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer s) {
				return s + 1;
				
			};
		};
		Integer three = add1.apply(10);
		System.out.println(two);
		System.out.println(three);
		System.out.println(atoi.apply("1"));
		System.out.println(atoi.apply("1") instanceof Integer);
	}

}
