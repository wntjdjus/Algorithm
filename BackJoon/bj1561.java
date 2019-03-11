package com.algorithm.day0121;

import java.util.Scanner;

public class bj1561 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		int m = sc.nextInt();
		int[] time = new int[m+1];
		for(int i = 1; i <= m; i++) {
			time[i] = sc.nextInt();
		}
		long right = 2000000000000L;
		long left = 1;
		long mid = 0;
		if(n <= m) {
			System.out.println(n);
			return;
		}
		while(left<=right) {
			mid = (right+left) / 2;
			long sum = 0;
			for(int i = 1; i <= m; i++) {
				sum += (mid / time[i])+1;
			}
			if(sum == n) {
				break;
			}
			else if(sum > n) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		long tn = 0;
		for(int i = 1; i <= m; i++) {
			tn += ((mid-1) / time[i]) + 1;
		}
		for(int i = 1; i <= m; i++) {
			if(mid % time[i] == 0) {
				tn++;
			}
			if(tn == n) {
				System.out.println(i);
				break;
			}
		}
	}

}
