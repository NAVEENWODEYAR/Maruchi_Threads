package com.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class CountDownLatchEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int numberOfServices = 4;
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		/*Future<String> submit1 = executorService.submit(new DependentService());
		Future<String> submit2 = executorService.submit(new DependentService());
		Future<String> submit3 = executorService.submit(new DependentService());
		Future<String> submit4 = executorService.submit(new DependentService());
		Future<String> submit5 = executorService.submit(new DependentService());
		
		submit5.get();
		submit1.get();
		submit2.get();
		submit3.get();
		submit4.get();
		
		System.out.println("All dependent services are finished,");
		executorService.shutdown();
	 */
	}
}

class DependentService implements Callable<String>{
	
	private final CountDownLatchEx countDownLatchEx;
	
	public DependentService(CountDownLatchEx countDownLatchEx) {
		this.countDownLatchEx = countDownLatchEx;
	}

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+" service started!,,");
		Thread.sleep(2000);
		return "\nOK\n";
	}
	
}
