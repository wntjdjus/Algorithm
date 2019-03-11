package com.algorithm.day0110;

import java.util.Scanner;

public class bj4811 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n == 0) break;
			long[][] dp = new long[n+1][n+1];
			/*for(int i = 0; i <= n; i++) {
				for(int j = 0; j <= n; j++) {
					if(i == 0 || j == 0) {
						dp[i][j] = 1;
					}
				}
			}*/
			System.out.println(Func(dp,n,0));
			//System.out.println(dp[n]);
		}
	}
	public static long Func(long[][] dp, int w, int h) {
		if(dp[w][h] != 0) return dp[w][h];
		if(w == 0) {
			dp[w][h] = 1;
		}
		else if(h == 0) {
			dp[w][h] = Func(dp,w-1,h+1);
		}
		else {
			dp[w][h] = Func(dp,w-1,h+1) + Func(dp,w,h-1);
		}
		return dp[w][h];
	}

}
