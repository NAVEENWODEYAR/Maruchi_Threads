package com.threads.debug;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("In Debug Mode,");
		Calci calci = new Calci();
				int add = calci.add(2, 2);
				float prod = calci.prod(1, 1);
		System.out.println("\nSum of given integers,"+add);
		System.out.println("\nProduct of given integers,"+prod);
	}

}
