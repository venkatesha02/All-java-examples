package com.tyss.junittest;

public class MyRestService {

	public String getStudentName() {
		
		return "Vinay";
		
	}
	
	public String getTeacherName() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Rowdy";
	}
}
