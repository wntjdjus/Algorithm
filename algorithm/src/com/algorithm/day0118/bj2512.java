package com.algorithm.day0118;

import java.util.Arrays;
import java.util.Scanner;

public class bj2512 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int total = sc.nextInt();
		Arrays.sort(arr);
		int left = 1;
		int right = arr[n-1];
		int max = 0;
		int max_t = 0;
		while(left <= right) {
			int mid = (left+right) / 2;
			int sum = 0;
			for(int i = 0; i < n; i++) {
				if(arr[i] > mid) {
					sum += mid;
				}
				else sum += arr[i];
			}
			if(sum <= total && sum >= max) {
				max = sum;
				left = mid+1;
				max_t = max_t>mid?max_t:mid;
			}
			else {
				right = mid-1;
			}
		}
		System.out.println(max_t);
	}

}
