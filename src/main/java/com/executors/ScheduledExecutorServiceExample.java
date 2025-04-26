package com.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class ScheduledExecutorServiceExample {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
		
//		scheduledExecutorService.schedule(
//				()->System.out.println("Task executes after 5 seconds only"),
//				5, 
//				TimeUnit.SECONDS);
//		scheduledExecutorService.shutdown();
		
		scheduledExecutorService.scheduleAtFixedRate(
				()->System.out.println("Executes in intervals of 5sec"), 5, 5, TimeUnit.SECONDS);

		scheduledExecutorService.schedule(
				()->{System.out.println("Initiating shutDown!,,!");
	},20,TimeUnit.SECONDS);
	
	}
}
