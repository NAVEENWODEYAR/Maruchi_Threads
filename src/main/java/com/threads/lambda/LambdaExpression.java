package com.threads.lambda;
/**
 * @author NaveenWodeyar
 * @date 01-Sept-2024
 */
public class LambdaExpression {

	public static void main(String[] args) {
		
		Runnable run= ()-> {
			System.out.println("Thread using LambdaExpression");
		};
		Thread t = new Thread(run);
		t.start();
	}
}
