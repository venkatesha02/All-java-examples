package com.tyss.jdbcapp.common;

public class TestB {

	// Sentence reverse not word
	public static String reverseWord(String str) {
		String word[] = str.split(" ");
		String result = "";
		int len = word.length;
		System.out.println(len);
		for (int i = word.length - 1; i >= 0; i--) {

			result = result + word[i] + " ";
		}
		return result;
	}

	// String Reverse
	public static String revers(String str) {

		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {

			result = result + str.charAt(i);

		}
		return result;
	}

	// Each String reverse not sentence
	public static String reverseEachWordNotSentence(String str) {

		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {

			result = result + str.charAt(i);

		}
		
		String as[] = result.split(" ");
		
		String r = "";
		
		for (int i = as.length - 1; i >= 0; i--) {
			
			r = r + as[i] + " ";
			
		}
		
		return r;
	}

	public static void main(String[] args) {

		String input = "Hello this is venki";
		System.out.println(input);

		// String s = reverseWord(input);
		// System.out.println(s);

		// String s = revers(input);
		// System.out.println(s);

		String s = reverseEachWordNotSentence(input);
		System.out.println(s);

	}

}
