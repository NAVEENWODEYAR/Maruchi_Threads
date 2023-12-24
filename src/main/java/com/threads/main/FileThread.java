package com.threads.main;

import java.io.IOException;

import com.threads.file.CreatingFile;

public class FileThread {

	public static void main(String[] args) throws IOException {
		CreatingFile c = new CreatingFile();
		c.createFile();
		c.writeToFile();
		c.readFile();
		System.out.println("\n File IO done,");
	}

}
