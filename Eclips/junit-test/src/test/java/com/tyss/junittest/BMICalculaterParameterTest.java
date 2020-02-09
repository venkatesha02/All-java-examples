package com.tyss.junittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BMICalculaterParameterTest {

	@ParameterizedTest
	@MethodSource("getBmiValues")
	void getBmiResultTest(double value, String result) {
		BMICalculater bmi = new BMICalculater();
		String actual = bmi.getBmiResult(value);
		assertEquals(result, actual);
	}

	static Stream<Arguments> getBmiValues() {
		return Stream.of(Arguments.arguments(18.6, "Normal"),
				Arguments.arguments(15.2, "Under Weight"),
				Arguments.arguments(23.2, "Normal"), 
				Arguments.arguments(26.2, "Over Weight"),
				Arguments.arguments(56.2, "Obesity"));
	}

}
