package com.test;

public class CtciArraLeftRotation {

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {

		int lenghtOfArray = a.length;
		int noOfShiftPosition = a.length - d;
		int[] intArray = new int[lenghtOfArray];

		if (d == 0 || d >= a.length) {
			return a;
		}

		int position1 = 0;
		for (int i = d; i <= lenghtOfArray - 1; i++) {

			intArray[position1] = a[i];
			position1++;
		}

		int position2 = noOfShiftPosition;
		for (int i = 0; i <= d - 1; i++) {

			intArray[position2] = a[i];
			position2++;
		}
		
		for (int i = 0; i <=intArray.length-1; i++) {
			
			System.out.println(intArray[i]);
		}

		return intArray;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 41,73,89,7,10,1,59,58,84,77,77,97,58,1,86,58,26,10,86,51};
		int d = 10;
		rotLeft(a, d);
		
		
	}

}
