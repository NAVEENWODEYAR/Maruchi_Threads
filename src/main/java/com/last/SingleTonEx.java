package com.last;

public class SingleTonEx {

	private SingleTonEx instance=null;
	
	private SingleTonEx(){
		System.out.println("Private Constructor");
	}
	
	public static SingleTonEx  getInstance()
	{
		if(instance==null) {
			instance= new SingleTonEx();
		}
		return instance;
	}
}
