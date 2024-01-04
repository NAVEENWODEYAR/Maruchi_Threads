package com.last;

public class SingleTonExImpl {

	public static void main(String[] args) {
		SingleTonEx s = SingleTonEx.getInstance();
		SingleTonEx s1 = SingleTonEx.getInstance();
		SingleTonEx s2 = SingleTonEx.getInstance();
		
		System.out.println(s.hashCode()+" =Welcome **2024**= "+s1.hashCode());
	}
}
