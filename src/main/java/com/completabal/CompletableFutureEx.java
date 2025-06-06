package com.completabal;

import java.util.concurrent.CompletableFuture;

/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class CompletableFutureEx {

	public static void main(String[] args) {
		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(5000);
				System.out.println("Worker Thread");
			} catch (Exception e) {
				e.getCause();
			}
			return "OK";
		});
		String s = null;
		try {
			s = supplyAsync.get();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		System.out.println(s);
		System.out.println("Main");
	}
}
