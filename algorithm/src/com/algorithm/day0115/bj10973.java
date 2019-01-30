package com.algorithm.day0115;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bj10973 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i <n; i++) {
			arr[i] = sc.nextInt();
		}
		int index = 0;
		for(int i = 1; i < n; i++) {
			if(arr[i] < arr[i-1]) index = i;
		}
		if(index == 0) {
			System.out.println(-1);
			return;
		}
		int index_t = index;
		int min = arr[index_t];
		for(int i = index; i < n; i++) {
			if(arr[i] < arr[index-1]) {
				index_t = i;
				min = arr[i];
			}
		}
		int temp = arr[index-1];
		arr[index-1] = min;
		arr[index_t] = temp;
		Integer[] iarr = new Integer[n-index];
		for(int i = 0; i < n-index; i++) {
			iarr[i] = arr[index+i];
		}
		Arrays.sort(iarr, Collections.reverseOrder());
		for(int i = 0; i < n-index; i++) {
			arr[index+i] = iarr[i];
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}