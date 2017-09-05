package com.generics.exs;

public class GenericClassExample<S> {
	S s;
	
	public GenericClassExample(S s) {
		this.s = s;
	}
	
	public S get() {
		return s;
	}
	
	public static void main(String[] args) {
		
		GenericClassExample<Integer> sInteger = new GenericClassExample<Integer>(10);
		GenericClassExample<Double> sDouble = new GenericClassExample<Double>(10.35);
		GenericClassExample<String> sString= new GenericClassExample<String>("Hello World");
		System.out.println(sInteger.get());
		System.out.println(sDouble.get());
		System.out.println(sString.get());
		
	}

}
