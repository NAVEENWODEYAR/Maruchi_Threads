package com.threads;

public class DeamonThreadEx extends Thread{
	@Override
	public void run() {
		super.run();
		setDaemon(true);
		System.out.println("Iam Daemon,");
	}
}
