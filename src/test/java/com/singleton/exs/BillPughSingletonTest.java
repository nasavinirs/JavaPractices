package com.singleton.exs;

class BillPughSingleton {

    private BillPughSingleton(){}
    
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}

public class BillPughSingletonTest {

	public static void main(String[] args) {
		BillPughSingleton instanceOne = BillPughSingleton.getInstance();
		BillPughSingleton instanceTwo = BillPughSingleton.getInstance();
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());

	}

}
