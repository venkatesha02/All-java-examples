package com.tyss.dsa.algo;

import java.time.Duration;
import java.time.Instant;

public class Algorithm {

	public static void main(String[] args) {
		countingDuration1();
		countingDuration();
		
	}
	
	public static long addUpto(long num) {
		long total = 0l;
		for (int i = 0; i <=num; i++) {
			total +=i;
		}
		return total;
	}
	
	public static long addUptoQuick(long num) {
		return num * (num+1)/2;
	}
	
	public static void countingDuration() {
		long num=99999999l;
		Instant start = Instant.now();
		System.out.println("AddUpto : "+addUpto(num));
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		double seconds = duration / 1000.0;
		System.out.println("AddUpto time : "+seconds+" Seconds");
	}
	public static void countingDuration1() {
		long num=99999999l;
		Instant start = Instant.now();
		System.out.println("AddUptoQuick : "+addUptoQuick(num));
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		double seconds = duration / 1000.0;
		System.out.println("AddUptoQuick time : "+seconds+" Seconds");
	}

}
