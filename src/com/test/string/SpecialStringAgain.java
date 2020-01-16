package com.test.string;

public class SpecialStringAgain {

	// Complete the substrCount function below.
	static long substrCount(int n, String s) {

		char charArray[] = s.toCharArray();

		long substrCount = s.length();
		
		long startPointer =0;
		long endPointer =1;

		for (long i = startPointer; i < endPointer; i++) {

		}

		System.out.println("Count : " + substrCount);
		return substrCount;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		substrCount(4, "aaaa");

	}

}
