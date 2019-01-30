package com.algorithm.code;

import java.util.Scanner;

public class bj9020 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sosu = new int[10001];
		sosu[1] = 1;
		for(int i = 2; i <= 10000; i++) {
			if(sosu[i] == 1) continue;
			for(int j = i + i; j <= 10000; j+= i) {
				sosu[j] = 1;
			}
		}
		int test = sc.nextInt();
		for(int t = 0; t < test; t++) {
			int n = sc.nextInt();
			for(int i = n / 2; i >= 2; i--) {
				if(sosu[i] == 1) continue;
				int temp = n - i;
				if(sosu[temp] == 0) {
					System.out.println(i+" "+temp);
					break;
				}
			}
		}
	}

}
