package com.recursion;

/**
 * @author NaveenWodeyar
 * @date 19-Jul-2025
 */

public class FibonacciSeries {

	public static void main(String[] args) {
		System.out.println("\nFibonacci Series using Recursion\n");
		int n = 20;
		
		for(int i=0; i<n; i++) {
			System.out.print(fiboSeries(i)+" ");
		}
		
		int fibNum = fiboNum(n);
		System.out.println("\nFiboNacci number for "+n+": "+fibNum);
		
	}
	
	static int fiboNum(int n) {
		if(n < 2) {
			return n;
		}
		return fiboNum(n-1) + fiboNum(n-2);
	}
	
	
	static int fiboSeries(int n) {
		 if ( n == 0) {
			 return 0;
		 } 
		 
		 if (n == 1) {
			 return 1;
		 }
		 return fiboSeries(n-1) + fiboSeries(n-2);
	
	}
}
