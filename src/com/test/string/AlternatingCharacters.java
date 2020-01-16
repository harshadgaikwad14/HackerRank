package com.test.string;

public class AlternatingCharacters {

	// Complete the alternatingCharacters function below.
	static int alternatingCharacters(String s) {

		int deleteCount = 0;

		final char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {

			for (int j = i + 1; j < charArray.length; j++) {

				if (charArray[i] != charArray[j]) {

					i = j - 1;
					break;

				} else {
					if (j <= charArray.length) {

						i = j;
						deleteCount++;
					}

				}

			}

		}

		// System.out.println("Delete Count : " + deleteCount);
		return deleteCount;
	}

	public static void main(String[] args) {

		alternatingCharacters("BBBBB");

	}

}
