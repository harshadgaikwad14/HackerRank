package com.test;

public class NewYearChaosEnglish {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {

		int pointer1 = 1;
		int pointer2 = 2;
		int pointer3 = 3;
		int tooChaoticCount = 0;

		for (int i = 0; i <= q.length - 1; i++) {

			if (q[i] > q[pointer1] && q[i] > q[pointer2] && q[i] > q[pointer3] && pointer1 != pointer2
					&& pointer1 != pointer3 && pointer3 != pointer2) {

				System.out.println("Too chaotic");
				return;
			} else {

				/*
				 * if (q[i] > q[pointer1] && i != pointer1) {
				 * updateTooChaoticCount(tooChaoticCountMap, q[i]); }
				 */

				for (int j = i + 1; j <= q.length - 1; j++) {

					if (q[i] > q[j]) {
						tooChaoticCount = tooChaoticCount + 1;
					}
				}

				if (q.length - 1 > pointer1) {

					pointer1++;
				}
				if (q.length - 1 > pointer2) {

					pointer2++;
				}
				if (q.length - 1 > pointer3) {

					pointer3++;
				}

			}

		}

		if (tooChaoticCount > 0) {
			System.out.println(tooChaoticCount);
		}

		/*
		 * Long sum = tooChaoticCountMap.values() .stream()
		 * .mapToLong(Long::valueOf) .sum();
		 * 
		 * System.out.println(sum);
		 */

	}

	/*
	 * public static void updateTooChaoticCount(final Map tooChaoticCountMap,
	 * final long key) {
	 * 
	 * if(tooChaoticCountMap.containsKey(key)) { long oldVal= (long)
	 * tooChaoticCountMap.get(key); tooChaoticCountMap.put(key, oldVal+1); }
	 * else { tooChaoticCountMap.put(key, 1); }
	 * 
	 * }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] q = { 1, 2, 5, 3, 7, 8, 6, 4 };
		// int[] q = { 2, 5, 1, 3, 4 };
		minimumBribes(q);

	}

}
