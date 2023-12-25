package com.threads.debug;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("In Debug Mode,");
		Calci calci = new Calci();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter integer values:");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
				int add = calci.add(a,b);
				float prod = calci.prod(a,b);
				
		if(add > prod)
			System.out.println("\nSum of given integers,"+add);
		else
			System.out.println("\nProduct of given integers,"+prod);
	}

}
