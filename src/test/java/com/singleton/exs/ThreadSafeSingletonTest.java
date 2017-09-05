package com.singleton.exs;

class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton(){}
    
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
    
}

public class ThreadSafeSingletonTest {

	public static void main(String[] args) {
		ThreadSafeSingleton instanceOne = ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton instanceTwo = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
		
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}

}
