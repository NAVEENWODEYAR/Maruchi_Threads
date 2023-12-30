package com.threads.main;

import java.io.IOException;

import com.threads.file.CreatingFile;

public class FileThread {

	public synchronized static void main(String[] args) throws IOException {
		CreatingFile c = new CreatingFile();
		CreatingFile c1 = new CreatingFile();
		CreatingFile c2 = new CreatingFile();
		c.createFile();
		c1.writeToFile();
		c2.readFile();
		System.out.println("\n File IO done,");
		System.out.println(Thread.currentThread());
	}

}
