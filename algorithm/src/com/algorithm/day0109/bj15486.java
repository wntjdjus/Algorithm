package com.algorithm.day0109;

import java.util.Scanner;

public class bj15486 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		int[] dp = new int[n+2];
		dp[0] = 0;
		for(int i = 1; i <= n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		for(int i = 1; i <= n; i++) {
			dp[i] = Math.max(dp[i], dp[i-1]);
			if(i+t[i] > n+1) {
				dp[i+1] = Math.max(dp[i+1], dp[i]);
				continue;
			}
			dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i] + p[i]);
		}
		
		System.out.println(dp[n+1]);
	}
	/*
	 * dp[i]는 i-1일 까지 일 하고 난 다음 받는 돈의 max 값
	 */
}