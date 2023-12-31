package com.last;

public class CloneEx implements Cloneable {

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneEx cl = new CloneEx();
		CloneEx cl1 = (CloneEx) cl.clone();
		
		System.out.println(cl.hashCode()+"=="+cl1.hashCode());
	}

}
