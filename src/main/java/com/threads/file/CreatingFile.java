package com.threads.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreatingFile extends Thread {
	
	// 1.creating file,
	public void createFile()
	{
		File f = new File("Thread.txt");
		try {
			if(f.createNewFile())
				System.out.println("File created,"+f.getName());
			else
				System.out.println("Error while file creation,");
		} catch (IOException e) {
			System.out.println(e.getCause());
		}
	}
	
	// 2. Writing to the file if exists,
	public void writeToFile() throws IOException
	{
		FileWriter writer = new FileWriter("Test.txt");
					writer.write("Welcome to file operations in the Java,\n Threads");
					writer.write("FileWriter provides writer to write into the file,\n");
					writer.close();
	}

	// 3. Reading file,
	public void readFile()
	{
		Scanner sc = new Scanner("Test.txt");
		while(sc.hasNextLine())
		{
			String st = sc.nextLine();
			System.out.println(st.getBytes());
		}
		sc.close();
	}
}
