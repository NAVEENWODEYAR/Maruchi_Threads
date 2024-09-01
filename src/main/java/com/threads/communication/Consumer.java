package com.threads.communication;
/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class Consumer implements Runnable {
	
	private SharedResources resources;
	
	public Consumer(SharedResources resources) {
		this.resources = resources;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000000000; i++) {
			resources.consume();
		}
	}

}
