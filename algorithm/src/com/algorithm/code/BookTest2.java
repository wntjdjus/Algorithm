package com.algorithm.code;

import java.util.Scanner;

public class BookTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test = 1; test <= t; test++) {
			int n = sc.nextInt();
			int so_num = sc.nextInt();
			int[][] arr = new int[n][n];
			int[] so_x = new int[so_num + 1];
			int[] so_y = new int[so_num + 1];
			int[] so_p = new int[so_num + 1];
			int number = 1;
			int answer = 0;
			for(int i = 1; i <= so_num; i++) {
				so_y[i] = sc.nextInt();
				so_x[i] = sc.nextInt();
				so_p[i] = sc.nextInt();
			}
			for(int i = 1; i <= so_num; i++) {
				int dy = so_y[i];
				int dx = so_x[i];
				if(arr[dy][dx] == 1) {
					answer = i;
					break;
				}
				arr[dy][dx] = 1;
				if(so_p[i] == 1) {
					// ¾Æ·¡
					for(int k = 3; k >= 1; k--) {
						dy += k;
						if(dy > n-1) {
							break;
						}
						else if(arr[dy][dx] == 1) {
							answer = i;
							break;
						}
						arr[dy][dx] = 1;
					}
				}
				else if(so_p[i] == 2){
					// À§
					for(int k = 3; k >= 1; k--) {
						dx += k;
						if(dx > n-1) {
							break;
						}
						else if(arr[dy][dx] == 1) {
							answer = i;
							break;
						}
						arr[dy][dx] = 1;
					}
				}
			}
			System.out.println("#"+test+" "+answer);
		}
	}

}
