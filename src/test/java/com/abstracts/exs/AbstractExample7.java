package com.abstracts.exs;

abstract class AbstractExamp {

    abstract public void add();
}


public class AbstractExample7 {

    public static void main(String n[])
    {
           
           AbstractExamp obj= new AbstractExamp() {

			public void add() {
				System.out.println("From add() method of Anonymous class");
			}
        	   
           };
           
           obj.add();
    }

}
