package com.test;

import java.io.IOException;

public class RepeatedString {

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {

		long count = 0;
		final String finalString;

		if (s == null || s.length() < 0) {
			return -1;
		}

		if (s.length() == 1 && s.equals("a")) {
			return n;

		} else if (s.length() == 1 && !s.equals("a")) {
			return 0;

		} else if (n == s.length() && s.length() == 1 && !s.equals("a")) {
			return -1;

		} else if (n <= s.length()) {
			finalString = s.substring(0, (int) n);
			count = charCount(finalString);
		} else {

			long noOfInteration = n / s.length();
			long lenghtAfterInteration = noOfInteration * s.length();
			long remainingCharCount = n - lenghtAfterInteration;

			long originaStringCharlCount = 0;
			long subStringCharCount = 0;

			originaStringCharlCount = charCount(s);

			long scount = originaStringCharlCount * noOfInteration;

			final String sbString = s.substring(0, (int) remainingCharCount);

			subStringCharCount = charCount(sbString);

			count = scount + subStringCharCount;

		}

		return count;

	}

	public static long charCount(final String data) {
		long count = 0;

		for (int i = 0; i <= data.length() - 1; i++) {

			char ch = data.charAt(i);
			if (ch == 'a') {

				count++;
			}

		}

		return count;
	}

	public static void main(String[] args) throws IOException {

		System.out.println("Count : " + repeatedString("aba", 10));

	}
}
