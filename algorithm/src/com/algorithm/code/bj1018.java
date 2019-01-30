package com.algorithm.code;

import java.util.Scanner;

public class bj1018 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] arr = new char[n][m];
		int min = 64;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.next().charAt(0);
			}
			sc.nextLine();
		}
		for(int i = 0; i <= n - 8; i++) {
			for(int j = 0; j <= m - 8; j++) {
				int count = 0;
				for(int x = i; x < i + 8; x++) {
					for(int y = j; y < j + 8; y++) {
						char temp;
						if((x % 2) + (y % 2) == 0) {
							temp = 'W';
						}
						else {
							temp = 'B';
						}
						if(arr[x][y] != temp) {
							count++;
						}
					}
				}
				min = count < min ? count : min;
				min = 64 - count < min ? count : min;
			}
		}
		System.out.println(min);
	}

}
