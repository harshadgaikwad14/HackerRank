package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SockMerchant {

	public static void main(String[] args) {
		
		int ar [] = {1,2,1,2,3,2,2};
		System.out.println(sockMerchant(ar.length, ar));

	}

	
	static int sockMerchant(int n, int[] ar) {

		if (n <= 0) {
			return -1;
		}
		
		int count = 0;

		Map<Integer, Integer> sockPairCountMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (sockPairCountMap.isEmpty()) {
				sockPairCountMap.put(ar[i], 1);
			} else {
				if (sockPairCountMap.containsKey(ar[i])) {
					int value = sockPairCountMap.get(ar[i]);
					sockPairCountMap.put(ar[i], value + 1);
				} else {
					sockPairCountMap.put(ar[i], 1);
				}
			}
		}
		
		for (Entry<Integer, Integer> key : sockPairCountMap.entrySet()) {
			
			final Integer val = (Integer)sockPairCountMap.get(key.getKey());
			
			if(val%2==0)
			{
				int data = val/2;
				count = count+data;
			}
			else
			{
				if(val!=1)
				{
					int data = val/2;
					count = count+data;
				}
			}

		}
		
		return count;

	}

}
