package com.pluralflights.tests;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciTest {
	
	public static void main(String[] args) {
		
		fibonacciUptoStreams(15);
		
		fibonacciRecursive(0,1,400);
	}

	
	private static void fibonacciRecursive(int secondLast, int last, int largest) {
		int nextDigit = secondLast+last;
		
		if(nextDigit>largest) {
			System.out.println(secondLast+"\n"+last);
			return ;
		}
		
		if(nextDigit==1) {
			System.out.println(0);
		}else {
			System.out.println(secondLast);
		}
		
		secondLast = last;
		last=nextDigit;
		fibonacciRecursive(secondLast, last, largest);
	}


	/**
	 * Fibonnacci using Streams, java 8. ref. - https://gist.github.com/artlovan/d7315b375f4553a1be1605b16c7a9098
	 * */
	private static void fibonacciUptoStreams(int max) {
		
		IntStream fibonacci = Stream.iterate(new int[]{0,1}, s -> new int[] {s[1],s[0]+s[1]})
					.limit(max)
					.map(n -> n[0]).mapToInt(n -> n);
		
		fibonacci.forEach(System.out::println);
	}

	

}
