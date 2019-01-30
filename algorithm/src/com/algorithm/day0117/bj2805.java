package com.algorithm.day0117;

import java.util.Arrays;
import java.util.Scanner;

public class bj2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] h = new int[n+1];
		h[0] = 0;
		int top = n;
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			h[i] = sc.nextInt();
		}
		Arrays.sort(h);
		int temp = 1;
		while(sum < m) {
			while(h[top] == h[top-1]) {
				temp++;
				top--;
			}
			sum += temp;
			h[top]--;
		}
		System.out.println(h[top]);
	}

}
