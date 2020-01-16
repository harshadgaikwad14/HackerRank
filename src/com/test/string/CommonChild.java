package com.test.string;

public class CommonChild {

	// Complete the commonChild function below.
	static int commonChild(String s1, String s2) {

		int count = 0;

		char[] chArr1 = s1.toCharArray();
		char[] chArr2 = s2.toCharArray();
		int s2CharPositionCount=0;
		

		for (int i = 0; i < chArr2.length; i++) {

			for (int j = 0; j < chArr1.length; j++) {
				
				if(chArr2[i]==chArr1[j])
				{
					count++;
					break;
				}

			}

		}

		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		commonChild("ABCD", "ABDC");
	}

}
