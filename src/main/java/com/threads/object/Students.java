package com.threads.object;

public class Students {

	private int stId;
	private String stName;
	
	public Students() {	}
	
	public Students(int i,String s){
		this.stId = i;
		this.stName = s;
	}
	
	@Override
	public boolean equals(Object obj) {
		Students s = (Students) obj;
		Students s1 = (Students) obj;
		
		System.out.println(Thread.currentThread());
		return (s1.stId == s.stId || s1.stName == s.stName);
	}
	
	public static void main(String[] args) {
		Students s = new Students(0, null);
		Students s1 = new Students(0, null);
		
		if(s.equals(s1))
			System.out.println("equals() overridden,");
		else if(s == s1)
			System.out.println("== opearator,");
		
	}
}
