package com.tyss.junittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SimpleCalTest {

//	@Test
//	@ParameterizedTest
//	@MethodSource("getResult")
//	void getDivResult(int a ,int b, int values) {
//		SimpleCal cal = new SimpleCal();
//		int actual = cal.division(a, b);
//		System.out.println(actual);
//		assertEquals(values, actual);
//		
//	}
//	
//	static Stream<Arguments> getResult(){	
//		return Stream.of(Arguments.arguments(5,5),
//				Arguments.arguments(20,62),
//				Arguments.arguments(20,62)	
//				);
//	}
	
	@Test
	void divByZeroException() {
		SimpleCal cal = new SimpleCal();
		assertThrows(ArithmeticException.class, ()->{
			cal.division(20, 0);
		});
	}
	
//	@Test
//	void divByZero() {
//		SimpleCal cal = new SimpleCal();
//		int i = cal.division(20, 0);
//		assertEquals(0, i);
//	}
	
	@Test
	void divPositiveTest() {
		SimpleCal cal = new  SimpleCal();
		int i = cal.division(10, 5);
		assertEquals(2, i);
	}
}
