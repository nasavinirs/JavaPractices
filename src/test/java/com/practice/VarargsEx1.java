package com.practice;

public class VarargsEx1 {

	public static void displayString(String... values) {
		System.out.println("From String method");
		
		for(String value : values) {
			System.out.println(value);
		}
	}
	
	public static void displayInt(String str, int... values) {
		System.out.println("From int method");
		
		for(int value : values) {
			System.out.println(value);
		}
	}

	
	public static void main(String[] args) {
		
		displayString("S1", "S2", "S3");
		displayInt("String", 1,2,3);
		
		// Output is 2
		// String arr[][][] = new String[2][100000][3];
		// System.out.println(arr.length); 
		
		// ClassCastException
		/* Object myObjects[] = {new Integer(12), new String("foo"), new Integer(5), new Boolean(true)};
		
		Arrays.sort(myObjects);
		
		for(int i=0;i<myObjects.length; i++) {
			System.out.println(myObjects[i].toString());
		} */
		
		// Output is 'y'
		String str = "";
		Boolean b1 = true;
		Boolean b2 = false;
		
		if((b2 = false) | (21%5) > 2) str +="x";
		if(b1 || (b2 = true)) str +="y";
		if(b2 == true) str +="z";
		
		System.out.println(str);
		
	}

}
