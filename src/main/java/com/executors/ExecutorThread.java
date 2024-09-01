package com.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class ExecutorThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Callable<Integer> callable1 = ()->{
			Thread.sleep(1000);
			System.out.println("TASK 1");
			return 1;
		};
		
		Callable<Integer> callable2 = ()->{
			Thread.sleep(1000);
			System.out.println("TASK 2");
			return 2;
		};
		
		Callable<Integer> callable3 = ()->{
			Thread.sleep(1000);
			System.out.println("TASK 3");
			return 3;
		};
		
		Callable<Integer> callable4 = ()->{
			Thread.sleep(1000);
			System.out.println("TASK 4");
			return 4;
		};
		
		Callable<Integer> callable5 = ()->{
			Thread.sleep(1000);
			System.out.println("TASK 5");
			return 5;
		};
		
		List<Callable<Integer>> list = Arrays.asList(callable1,callable2,callable3,callable4,callable5);
		List<Future<Integer>> invokeAll = executorService.invokeAll(list,1,TimeUnit.SECONDS);
		
		for(Future<Integer> future: invokeAll) {
			System.out.println(future.get());
		}
		
		executorService.shutdown();
		System.out.println("Executor Services,,");
	}
	
}
