package com.threads.main;

import com.threads.StartThread;

public class EntryPoint {

	public static void main(String[] args) {
		StartThread t = new StartThread();
					t.start();
		System.out.println("main(),");
	}

}
