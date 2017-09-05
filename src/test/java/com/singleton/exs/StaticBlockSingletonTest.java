package com.singleton.exs;

class StaticBlockSingleton {

    private static StaticBlockSingleton instance;
    
    private StaticBlockSingleton(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}

public class StaticBlockSingletonTest {

	public static void main(String[] args) {
		StaticBlockSingleton instanceOne = StaticBlockSingleton.getInstance();
		StaticBlockSingleton instanceTwo = StaticBlockSingleton.getInstance();
		
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}

}
