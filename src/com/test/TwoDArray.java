package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Postion {

	private int initial;
	private int last;

	public int getInitial() {
		return initial;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + initial;
		result = prime * result + last;
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
		Postion other = (Postion) obj;
		if (initial != other.initial)
			return false;
		if (last != other.last)
			return false;
		return true;
	}

	public Postion(int initial, int last) {
		super();
		this.initial = initial;
		this.last = last;
	}

	@Override
	public String toString() {
		return "Postion [initial=" + initial + ", last=" + last + "]";
	}

}

public class TwoDArray {

	static int hourglassSum(int[][] arr) {

		/*
		 * for (int i = 0; i < arr.length; i++) { for (int j = 0; j <
		 * arr[i].length; j++) {
		 * 
		 * System.out.print(arr[i][j] + " ");
		 * 
		 * } System.out.println(""); }
		 */

		int maxSum = arrayPositionPlotting(arr);

		// System.out.println("===================== Sum : " + maxSum);
		return maxSum;

	}

	public static int arrayPositionPlotting(final int[][] arr) {

		int row = arr.length;
		int column = arr[0].length;
		System.out.printf("size is %d x %d%n", row, column);

		final Map<Postion, List<Postion>> postionMap = new HashMap<>();

		// for row
		for (int i = 0; i < arr.length; i++) {
			int intial = i;
			int last = i + 3;
			if (last <= row) {
				final List<Postion> list = new ArrayList<Postion>();
				// for column
				for (int j = 0; j < arr[i].length; j++) {
					int cIntial = j;
					int cLast = j + 3;
					if (cLast <= column) {

						list.add(new Postion(cIntial, cLast));

					}
				}

				postionMap.put(new Postion(intial, last), list);
			}
		}

		// System.out.println("Map : " + postionMap);

		Set<Integer> sumData = new HashSet<>();

		for (final Entry<Postion, List<Postion>> map : postionMap.entrySet()) {

			final Postion rowPostion = map.getKey();
			final List<Postion> listPositions = map.getValue();
			for (final Postion columnPostion : listPositions) {

				int sum = arrayPrint(arr, rowPostion.getInitial(), rowPostion.getLast(), columnPostion.getInitial(),
						columnPostion.getLast());
				sumData.add(sum);
			}

		}

		int maxNumber = sumData.stream().max(Comparator.comparing(Integer::valueOf)).get();

		return maxNumber;
	}

	public static int arrayPrint(final int[][] arr, final int rowFrom, final int rowTo, final int columnFrom,
			final int coulmnTo) {

		int count = 0;
		int arraySum = 0;
		for (int i = rowFrom; i < rowTo; i++) {

			for (int j = columnFrom; j < coulmnTo; j++) {

				// System.out.print(arr[i][j] + " ");
				count = count + arr[i][j];

			}

			// System.out.println("");

		}
		/*
		 * System.out.println("REMOVED VALUE :" + arr[rowFrom + 1][columnFrom]);
		 * System.out.println("REMOVED VALUE :" + arr[rowFrom + 1][coulmnTo -
		 * 1]);
		 */
		arraySum = count - arr[rowFrom + 1][columnFrom] - arr[rowFrom + 1][coulmnTo - 1];

		// System.out.println("Count : " + arraySum);

		return arraySum;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 }, { 0, 0, 2, 4, 4, 0 },
				{ 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };
		hourglassSum(arr);
	}

}
