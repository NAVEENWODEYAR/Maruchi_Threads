package com.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class ThreadPoolingEx {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(50);
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 1; i < 49; i++) {
			int finali = i;
			executor.submit(() -> {
				long result = factorial(finali);
				System.out.println("Factorial of" + finali + "!: " + result);
			});
		}
		executor.shutdown();
//		executor.shutdownNow();
		try {
			executor.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException();
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
