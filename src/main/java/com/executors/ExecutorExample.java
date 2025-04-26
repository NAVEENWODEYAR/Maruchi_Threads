package com.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class ExecutorExample {

	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
		Future<?> submit = newFixedThreadPool.submit(()->{
			System.out.println("Hello");
		});
		if(submit.isDone()) {
			System.out.println("Task done!");
		}
		try {
			System.out.println(submit.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		newFixedThreadPool.shutdown();
	}
}
