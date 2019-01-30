package com.algorithm.code;

import java.util.Scanner;

public class Solution2072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++) {
			int[] arr = new int[10];
			int sum = 0;
			for(int a : arr) {
				a = sc.nextInt();
				if(a != 0 && a % 2 == 1) {
					sum += a;
				}
			}
			System.out.println("#"+i+" "+sum);
		}
	}

}
