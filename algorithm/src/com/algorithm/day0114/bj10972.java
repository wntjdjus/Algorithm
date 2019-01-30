package com.algorithm.day0114;

import java.util.Arrays;
import java.util.Scanner;

public class bj10972 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int index = n-1;
		int flag = 0;
		for(int i = 1; i < n; i++) {
			if(arr[i] > arr[i-1]) {
				index = i;
				flag = 1;
			}
		}
		if(flag == 0) {
			System.out.println(-1);
			return;
		}
		int max = arr[index];
		int max_index = index;
		for(int i = index; i < n; i++) {
			if(arr[i] > arr[index-1]) {
				max = arr[i];
				max_index = i;
			}
		}
		int temp = max;
		arr[max_index] = arr[index-1];
		arr[index-1] = temp;
		//Arrays.sort(arr,index,n);
		arraySort(arr,index,n);
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	private static void arraySort(int[] arr, int index, int n) {
		for(int i = index; i < n-1; i++) {
			int max = arr[i];
			int max_i = i;
			for(int j = index+1; j < n; j++) {
				if(arr[j] < max) {
					max = arr[j];
					max_i = j;
				}
			}
			int temp = arr[i];
			arr[i] = max;
			arr[max_i] = temp;
		}
	}
}
