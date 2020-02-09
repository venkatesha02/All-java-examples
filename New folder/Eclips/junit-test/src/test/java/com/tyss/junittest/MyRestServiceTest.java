package com.tyss.junittest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class MyRestServiceTest {

	
	@Test
	@Timeout(value = 1000,unit = TimeUnit.MILLISECONDS)
	void getStudentNameTest() {
		
		MyRestService my = new MyRestService();
		String name = my.getStudentName();
		assertNotNull(name);
	}

	@Test
	@Timeout(value = 1000,unit = TimeUnit.MILLISECONDS)
	void getTeacherNameTest() {
		
		MyRestService my = new MyRestService();
		String name = my.getTeacherName();
		assertNotNull(name);
		
	}
}
