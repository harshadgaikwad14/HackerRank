package com.test.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SherlockAndTheValidString {

	// Complete the isValid function below.
	static String isValid(String s) {

		String isValid = "YES";

		final char[] charArray = s.toCharArray();
		final Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < charArray.length; i++) {

			final char ch = charArray[i];
			if (map.containsKey(ch)) {

				map.put(ch, map.get(ch) + 1);

			} else {

				map.put(ch, 1);
			}

		}

		int minValue = 0;
		int minValueCount = 0;
		int maxValue = 0;
		int maxValueCount = 0;
		int commonValue = 0;
		int commonValueCount = 0;

		int index = 0;
		for (Entry<Character, Integer> c : map.entrySet()) {

			if (index == 0) {
				minValue = c.getValue();
				maxValue = c.getValue();
				commonValue = c.getValue();
				minValueCount++;
				maxValueCount++;
				commonValueCount++;
				index++;
			} else {
				if (minValue < c.getValue()) {
					minValue = c.getValue();
					minValueCount++;

				}
				if (maxValue <= c.getValue()) {
					maxValue = c.getValue();
					maxValueCount++;
				}
				if (commonValue == c.getValue()) {
					commonValue = c.getValue();

					commonValueCount++;
				}
			}

		}

		System.out.println("MinValue : " + minValue +" minValueCount : "+minValueCount);
		System.out.println("maxValue : " + maxValue +" maxValueCount : "+maxValueCount);
		System.out.println("commonValue : " + commonValue +" commonValueCount : "+commonValueCount);

		if (maxValue == commonValue && minValue == 1) {
			isValid = "YES";
		} else {
			isValid = "NO";
		}
		System.out.println(isValid);
		return isValid;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		isValid("aabbccddeefghi");

	}

}
