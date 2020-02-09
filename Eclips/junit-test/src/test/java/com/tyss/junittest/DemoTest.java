package com.tyss.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test demo Class")
class DemoTest {

	@Test
	@DisplayName("add method testing")
	void addTest() {
		Calculater cal = new Calculater();
		int a = cal.add(10,5);
		assertEquals(15, a);
	}
	
	@Test
	@DisplayName("negative testing")
	void negativeTest() {
		Calculater cal = new Calculater();
		int a = cal.add(-10,-5);
		assertEquals(-15, a);
	}
	

}
