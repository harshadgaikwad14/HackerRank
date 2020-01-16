package com.test.string;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MakingAnagrams {

	// Complete the makeAnagram function below.
	static int makeAnagram(final String a, final String b) {

		int count = 0;
		final char[] str1CharArray = a.toCharArray();
		final char[] str2CharArray = b.toCharArray();

		final List<Character> str1CharList = new CopyOnWriteArrayList<>();
		final List<Character> str2CharList = new CopyOnWriteArrayList<>();

		for (final char ch1 : str1CharArray) {
			str1CharList.add(ch1);
		}
		for (final char ch2 : str2CharArray) {
			str2CharList.add(ch2);
		}

		// System.out.println("str1CharList : "+str1CharList);
		// System.out.println("str2CharList : "+str2CharList);

		if (str1CharList.size() <= str2CharList.size()) {
			removeCommonElementFromLists(str1CharList, str2CharList);
		} else {
			removeCommonElementFromLists(str2CharList, str1CharList);
		}

		// System.out.println("str1CharList : "+str1CharList);
		// System.out.println("str2CharList : "+str2CharList);

		count = str1CharList.size() + str2CharList.size();

		return count;
	}

	public static void removeCommonElementFromLists(final List<Character> str1CharList,
			final List<Character> str2CharList) {
		for (final Character character : str1CharList) {

			if (str2CharList.contains(character)) {
				str2CharList.remove(character);
				str1CharList.remove(character);
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");

	}

}
