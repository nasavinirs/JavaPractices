package com.singleton.exs;

class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;
    
    private LazyInitializedSingleton(){}
    
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

public class LazyInitializedSingletonTest {

	public static void main(String[] args) {
		LazyInitializedSingleton instanceOne = LazyInitializedSingleton.getInstance();
		LazyInitializedSingleton instanceTwo = LazyInitializedSingleton.getInstance();
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
		if (instanceOne.hashCode() == instanceTwo.hashCode())
			System.out.println("Single Instance");
		else
			System.out.println("Not Single Instance");
	}

}
