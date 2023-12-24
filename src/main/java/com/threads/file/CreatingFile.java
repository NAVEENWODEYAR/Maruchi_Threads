package com.threads.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreatingFile {
	void createFile()
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
	
	void writeToFile() throws IOException
	{
		FileWriter writer = new FileWriter("Test.txt");
					writer.write("Welcome tot file operations in the Java,");
					writer.close();
		
	}

}
