package com.threads.object;

public class OverrideEquals {

	public static void main(String[] args) {
		Students students = new Students(1,"Ammie");
		Students students1 = new Students(1,"Ammie");
		
		if(students.equals(students1))
			System.out.println("Objects are equal");
		else
			System.out.println("equals() overridden!");
	}

}
