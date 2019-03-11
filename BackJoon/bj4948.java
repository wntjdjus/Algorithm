package com.algorithm.code;

import java.util.Scanner;

public class bj4948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sosu = new int[246913];
		int temp = (int)Math.sqrt(246913);
		sosu[1] = 1;
		for(int i = 2; i <= 246912; i++) {
			if(sosu[i] == 1) continue;
			for(int j = i + i; j <= 246912; j += i) {
				sosu[j] = 1;
			}
		}
		while(true) {
			int n = sc.nextInt();
			if(n == 0) return;
			int count = 0;
			for(int i = n + 1; i <= 2 * n; i++) {
				if(sosu[i] == 0) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
