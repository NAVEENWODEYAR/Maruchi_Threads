package com.recursion;

/**
 * @author NaveenWodeyar
 * @date 19-Jul-2025
 */

public class FactorialOfNumber {

	public static void main(String[] args) {
		System.out.println("\nFactorial Of an given number: \n"+recrisiveFact(4));
	}
	
	static int recrisiveFact(int n) {
		System.out.println("\nFactorial using Recursion");
		if(n == 0 || n == 1) {
			return 1;
		}
		return n * recrisiveFact(n-1);
	}
	
	static int iterativeFact(int n) {
		System.out.println("\nFactorial using Iteration");
		int fact = 1;;
		for(int i=2; i<n; i++) {
			fact = fact *i;
		}
		return fact;
	}
}
