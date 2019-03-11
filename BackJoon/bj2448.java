package com.algorithm.code;

import java.util.Scanner;

public class bj2448 {
	//char[][] arr = new char[n*2-1][n*2-1];
	public static void func(int n, int y, int x) {
		if(n == 3) {
			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n*2-2; i++) {
			for(int j = 0; j < n*2-2; j++) {
				//arr[i][j] = ' ';
			}
		}
		int point_y = 0, point_x = n / 2;
		func(n, point_y, point_x);
	}

}
