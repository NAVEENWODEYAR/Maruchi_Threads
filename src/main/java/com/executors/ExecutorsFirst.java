package com.executors;

/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class ExecutorsFirst {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Thread[] threads = new Thread[49];
		for (int i = 1; i < 49; i++) {
			int finali = i;
			 threads[i-1] = new Thread(
					()-> {
						long result = factorial(finali);
						System.out.println("Factorial of"+finali+"!: "+ result);
					});
			threads[i-1].start();
		}
		for(Thread thread : threads) {
			try {
				thread.join();
			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("\nTotal time: "+(System.currentTimeMillis() - startTime));
	}

	private static long factorial(int n) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long result = 1;
		for (int i = 1; i < n; i++) {
			result *= i;
		}
		return result;
	}
}
