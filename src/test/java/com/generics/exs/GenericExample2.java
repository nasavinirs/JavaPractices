package com.generics.exs;

// Class type is different <H>
class Sample2<H> {
	
	// Method type is different
	public <G> void print(G g) {
		System.out.println(g);
	}
	
}

public class GenericExample2 {

	public static void main(String[] args) {
		Sample2<Character> obj1 = new Sample2<Character>();
		obj1.print("Hello");
		obj1.print(10);
		obj1.print(10.44f);
	}

}
