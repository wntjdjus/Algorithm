package com.algorithm.code;

import java.util.Scanner;

public class BookTest3 {

	public static void main(String[] args) {
		int[] dy = {0, -1, 0, 1, 0};
		int[] dx = {0, 0, 1, 0, -1};
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test = 1; test <= t; test++) {
			int n = sc.nextInt();
			int[][] arr = new int[n+1][n+1];
			int sy = sc.nextInt();
			int sx = sc.nextInt();
			int j_num = sc.nextInt();
			for(int i = 0; i < j_num; i++) {
				int jy = sc.nextInt();
				int jx = sc.nextInt();
				arr[jy][jx] = -1; // JUMP
			}
			int func_num = sc.nextInt();
			int[][] func_arr = new int[func_num][2];
			for(int i = 0; i < func_num; i++) {
				func_arr[i][0] = sc.nextInt();
				func_arr[i][1] = sc.nextInt();
			}
			for(int i = 0; i < func_num; i++) {
				for(int j = 0; j < func_arr[i][1]; j++) {
					sy += dy[func_arr[i][0]];
					sx += dx[func_arr[i][0]];
					if(sx > n || sx < 1 || sy > n || sy < 1) {
						sx = 0;
						sy = 0;
						break;
					}
					if(arr[sy][sx] == -1) {
						sx = 0;
						sy = 0;
						break;
					}
				}
			}
			System.out.println("#"+test+" "+sy+" "+sx);
		}
	}

}
