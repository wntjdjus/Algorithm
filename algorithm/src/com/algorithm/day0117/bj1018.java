package com.algorithm.day0117;

import java.util.Scanner;

public class bj1018 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int white = 0;
		int[][] arr = new int[y][x];
		for(int i = 0; i < y; i++) {
			if(i % 2 == 0) white = 1;
			else white = 0;
			String s = sc.next();
			for(int j = 0; j < x; j++) {
				char c = s.charAt(j);
				int wb = 0;
				if(c == 'W') wb = 1;
				if(white != wb) arr[i][j] = 1;
				white = swap(white);
			}
		}
		int min = 64;
		for(int i = 0; i < y - 7; i++) {
			for(int j = 0; j < x - 7; j++) {
				int count = 0;
				for(int n = i; n < i+8; n++) {
					for(int m = j; m < j+8; m++) {
						if(arr[n][m] == 1) {
							count++;
						}
					}
				}
				count = count<(64-count)?count:64-count;
				min = min<count?min:count;
			}
		}
		System.out.println(min);
	}
	private static int swap(int n) {
		return n == 0 ? 1:0;
	}

}
