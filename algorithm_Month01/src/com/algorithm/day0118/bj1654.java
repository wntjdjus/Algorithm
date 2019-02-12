package com.algorithm.day0118;

import java.util.Arrays;
import java.util.Scanner;

public class bj1654 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		long n = sc.nextInt();
		long[] length = new long[k];
		for(int i = 0; i < k; i++) {
			length[i] = sc.nextInt();
		}		
		Arrays.sort(length);
		long left = 1;
		long right = length[k-1];
		long max = length[k-1];
		while(left <= right) {
			long mid = (left+right) / 2;
			long sum = 0;
			for(int i = 0; i < k; i++) {
				if(length[i] < mid) continue;
				sum += (length[i] / mid);
			}
			if(sum >= n) {
				max = mid;
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		System.out.println(max);
	}

}
