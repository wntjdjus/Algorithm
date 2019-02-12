package com.algorithm.code;

import java.util.Scanner;

public class bj2775 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 0; t < test; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[][] apart = new int[k+1][n+1];
			for(int i = 1; i <= n; i++) {
				apart[0][i] = i;
			}
			for(int i = 1; i <= k; i++) {
				for(int j = 1; j <= n; j++) {
					for(int temp = 1; temp <= j; temp++) {
						apart[i][j] += apart[i-1][temp];
					}
				}
			}
			System.out.println(apart[k][n]);
		}
	}

}
