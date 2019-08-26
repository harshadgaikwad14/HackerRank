package com.test;

public class CountingValleys {

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {

		int count = 0;

		int seaLevel = 0;

		for (int i = 0; i <= n - 1; i++) {

			final char ch = s.charAt(i);

			if (ch == 'U') {
				seaLevel++;

			} else if (ch == 'D') {

				seaLevel--;

			}

			if (s.charAt(i) == 'U' && seaLevel == 0) {
				count++;
			}

		}

		return count;

	}

	public static void main(String[] args) {

		System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
	}

}
