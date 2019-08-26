package com.test;

public class JumpingOnTheClouds {

	public static void main(String[] args) {

		int a[] = { 0 ,0 ,0 ,1 ,0 ,0};
		System.out.println(jumpingOnClouds(a));
	}

	static int jumpingOnClouds(int[] c) {

		int firstPointer = 0;
		int middlePointer = 1;
		int lastPointer = 2;
		int jumpCount = 0;
		for (int i = 0; i < c.length - 1; i++) {

			if (c[firstPointer] != 0 && c[c.length - 1] != 0) {
				return -1;
			} 
			
			else if(middlePointer<=c.length - 1 && lastPointer<=c.length - 1)
			{
				
				if(c[firstPointer] == 0 && c[middlePointer] == 0 && c[lastPointer] == 0)
				{
					firstPointer = lastPointer;
					middlePointer = lastPointer+1;
					lastPointer = lastPointer+2;
					jumpCount++;
				}
				
				else if(c[firstPointer] == 0 && c[middlePointer] == 1 && c[lastPointer] == 0)
				{
					firstPointer = lastPointer;
					middlePointer = lastPointer+1;
					lastPointer = lastPointer+2;
					jumpCount++;
				}
				else if(c[firstPointer] == 0 && c[middlePointer] == 0 && c[lastPointer] == 1)
				{
					firstPointer = middlePointer;
					middlePointer = lastPointer;
					lastPointer = lastPointer+1;
					jumpCount++;
				}
			}
			else if(middlePointer<=c.length - 1 && lastPointer>c.length - 1)
			{
				 if(c[firstPointer] == 0 && c[middlePointer] == 0)
				{
					firstPointer = middlePointer;
					middlePointer = lastPointer;
					lastPointer = lastPointer+1;
					jumpCount++;
				}
			}
			

		}

		return jumpCount;

	}

}
