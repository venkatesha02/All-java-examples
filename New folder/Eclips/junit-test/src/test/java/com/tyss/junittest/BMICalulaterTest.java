package com.tyss.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BMICalulaterTest {

	@Test
	void getBmiResultUnderWeightTest() {
		BMICalculater bmi = new BMICalculater();
		String actual = bmi.getBmiResult(15.2);
		assertEquals("Under Weight", actual);

	}

	@Test
	void getBmiResultNormalTest() {
		BMICalculater bmi = new BMICalculater();
		String actual = bmi.getBmiResult(20.2);
		assertEquals("Normal", actual);

	}

	@Test
	void getBmiResultOverWeightTest() {
		BMICalculater bmi = new BMICalculater();
		String actual = bmi.getBmiResult(26.2);
		assertEquals("Over Weight", actual);

	}

	@Test
	void getBmiResultObesityTest() {
		BMICalculater bmi = new BMICalculater();
		String actual = bmi.getBmiResult(36.2);
		assertEquals("Obesity", actual);

	}

}
