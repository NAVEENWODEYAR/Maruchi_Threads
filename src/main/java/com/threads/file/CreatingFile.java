package com.threads.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreatingFile {
	// 1.creating an file,
	public void createFile()
	{
		File f = new File("Test.txt");
		try {
			if(f.createNewFile())
				System.out.println("File created,"+f.getName());
			else
				System.out.println("Error in creating");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	// 2. Writing to the file,
	public void writeToFile() throws IOException
	{
		FileWriter writer = new FileWriter("Test.txt");
					writer.write("Welcome tot file operations in the Java,");
					writer.close();
					System.out.println("\n");
	}
	
	// 3. Reading file,
	public void readFile()
	{
		Scanner sc = new Scanner("Test.txt");
		while(sc.hasNextLine())
		{
			String st = sc.nextLine();
			System.out.println(st);
		}
		sc.close();
			
		
	}
}
