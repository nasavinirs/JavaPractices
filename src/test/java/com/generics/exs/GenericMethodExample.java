package com.generics.exs;

public class GenericMethodExample {

	public <G> G print(G g) {
		return g;
	}
	
	public <G> void swap(G g1, G g2) {
		System.out.println("Before Sorting Values: " + g1 + " & " + g2);
		G temp = g1;
		g1 = g2;
		g2 = temp;
		System.out.println("After Sorting Values: " + g1 + " & " + g2);		
	}
	
	public static void main(String[] args) {
		GenericMethodExample obj = new GenericMethodExample();
		System.out.println(obj.print(10));
		System.out.println(obj.print(10.56));
		System.out.println(obj.print("Testing"));
		
		obj.swap(10, 20);
		obj.swap(10.25, 25.10);
		obj.swap("Hello", "World");
	}

}
