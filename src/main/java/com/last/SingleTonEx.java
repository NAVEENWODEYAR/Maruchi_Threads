package com.last;

public class SingleTonEx {

	// Static variable reference of single_instance,
	private static SingleTonEx instance=null;
	
	// private constructor,
	private SingleTonEx(){
		System.out.println("Private Constructor");
	}
	
	// Static method to create instance of Singleton class
	public static SingleTonEx getInstance()
	{
		if(instance==null) 
			instance= new SingleTonEx();
		return instance;
	}
}
