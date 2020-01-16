package com.test.map.example;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapBucketInfo {

	// This is to simulate instances which are not equal but go to the same
	// bucket.
	static class A {
		private long key;

		public A(long key) {
			super();
			this.key = key;
		}

		public long getKey() {
			return key;
		}

		public void setKey(long key) {
			this.key = key;
		}

		@Override
		public String toString() {
			return "A [key=" + key + "]";
		}

		@Override
		public int hashCode() {
			int result = 1;
			/*
			 * final int prime = 31; int result = 1; result = prime * result +
			 * (int) (key ^ (key >>> 32));
			 * System.out.println("key : "+key+" - result : "+result+" mod : "
			 * +result%16); return result;
			 */

			result = (int) (key % 16);
			System.out.println("key : " + key + " - result : " + result);

			return result;

		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			A other = (A) obj;
			if (key != other.key)
				return false;
			return true;
		}

	}

	public static void main(String[] args) throws Exception {
		// Test data
		HashMap<A, String> map = new HashMap<A, String>(16,16.0f);
		for (long i = 1; i <= 200; i++) {

			map.put(new A(i), "Value" + i);
		}
		
		System.out.println(map);
		
		for (Entry<A, String> mapData : map.entrySet()) {
			
			System.out.println("Key : "+mapData.getKey()+" >> Value : "+mapData.getValue());
			
		}

		// Access to the internal table
		Class clazz = map.getClass();
		Field table = clazz.getDeclaredField("table");
		table.setAccessible(true);
		Map.Entry<Integer, String>[] realTable = (Map.Entry<Integer, String>[]) table.get(map);

		// Iterate and do pretty printing
		for (int i = 0; i < realTable.length; i++) {

			//System.out.println(String.format("Bucket : %d, Entry: %s", i, bucketToString(realTable[i])));

		}

	}

	private static String bucketToString(Map.Entry<Integer, String> entry) throws Exception {
		if (entry == null)
			return null;
		StringBuilder sb = new StringBuilder();

		// Access to the "next" filed of HashMap$Node
		Class clazz = entry.getClass();

		Field next = clazz.getDeclaredField("next");
		next.setAccessible(true);

		// going through the bucket
		while (entry != null) {
			sb.append(entry);
			entry = (Map.Entry<Integer, String>) next.get(entry);
			if (null != entry)
				sb.append(" -> ");
		}
		return sb.toString();
	}
}
