package com.generics.exs;

class Sample<Z,W> {
	Z z;
	W w;
	
	public void setZ(Z z) {
		this.z = z;
	}
	
	public void setW(W w) {
		this.w = w;
	}
	
	public Z getZ() {
		return z;		
	}
	
	public W getW() {
		return w;
	}
	
	// This is non generic method in Generic class
	public void print() {
		System.out.println("Non generic method");
	}
}

public class GenericsExample1 {

	public static void main(String[] args) {
		
		Sample<Integer, String> obj = new Sample<Integer, String>();
		
		obj.setW("Hello");
		obj.setZ(10);
		
		System.out.println(obj.getW());
		System.out.println(obj.getZ());
		
		obj.print(); // Non Generic Method
	}

}
