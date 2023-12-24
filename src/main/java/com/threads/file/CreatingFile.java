package com.threads.file;

import java.io.File;
import java.io.IOException;

public class CreatingFile {
	
	public static void main(String[] args) throws IOException {
		File f = new File("Test.txt");
		if(f.createNewFile())
			System.out.println("File created,");
		else
			System.out.println("Error in creating");
	}
}
