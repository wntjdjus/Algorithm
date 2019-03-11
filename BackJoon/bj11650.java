package com.algorithm.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj11650 {
	public static void sortArray(int[][] arr) {
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] arr1, int[] arr2) {
				if(((Comparable)arr1[0]).compareTo(arr2[0]) < 0) {
					return -1;
				}
				else if(((Comparable)arr1[0]).compareTo(arr2[0]) == 0) {
					if(((Comparable)arr1[1]).compareTo(arr2[1]) < 0) {
						return -1;
					}
					else {
						return 1;
					}
				}
				else {
					return 1;
				}
			}
		});
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		sortArray(arr);
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}

}
