package com.threads.communication;

/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */

class SharedResources{
	private int data;
	
	private boolean hasData;
	
	public synchronized void produce(int value) {
		while(hasData) {
			try {
				wait();
			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
		}
		
		data = value;
		hasData = true;
		System.out.println("Produced: "+value);
		notify();
		
	}
	
	public synchronized int consume() {
		while(!hasData) {
			try {
				wait();
			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
		}
		hasData = false;
		System.out.println("Consumed: "+data);
		notify();
		return data;
	}
}


public class ThreadCommunication {
	
	public static void main(String[] args) {
		SharedResources resources = new SharedResources();
		Thread producerThread = new Thread(new Producer(resources));
		Thread consumerThread = new Thread(new Consumer(resources));
		
		producerThread.start();
		consumerThread.start();
	}
	
}
