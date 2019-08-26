package com.test;

public class Test5 {

	static int minimumSwaps(int[] arr) {

		int count = 0;

		System.out.print("Before Sort : ");
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {

			for (int j = 1 + 1; j < arr.length; j++) {

				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

					count++;
				}
			}

		}
		System.out.println("-----");

		System.out.print("After Sort : ");
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i]);
		}

		System.out.println("Count : " + count);

		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 3, 4, 1, 5 };
		minimumSwaps(arr);
	}

}
