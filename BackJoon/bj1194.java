package com.algorithm.day0121;

import java.util.Scanner;

public class bj1194 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,1,-1};
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] arr = new char[n][m];
		int[][][] flag = new int[n][m][(1<<7)];
		int[][][] count = new int[n][m][(1<<7)];
		int[][] q = new int[200000][3];
		//int[][] q = new int[17051][3];
		int head = -1;
		int tail = -1;
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			for(int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j);
				if(arr[i][j] == '0') {
					flag[i][j][0] = 1;
					count[i][j][0] = 0;
					tail++;
					q[tail][0] = i;
					q[tail][1] = j;
					q[tail][2] = 0;
				}
			}
		}
		while(head!=tail) {
			head++;
			int y = q[head][0];
			int x = q[head][1];
			int key = q[head][2];
			for(int i = 0; i < 4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x >= 0 && temp_x < m && temp_y >= 0 && temp_y < n) {
					if(flag[temp_y][temp_x][key] == 1) continue;
					char c = arr[temp_y][temp_x];
					 if(c == '#') continue;
					 else if(c >= 'A' && c <= 'Z') {
						 if((key&1<<(c-'A')) == 0) {
							 continue;
						 }
						 flag[temp_y][temp_x][key] = 1;
						 count[temp_y][temp_x][key] = count[y][x][key]+1;
						 tail++;
						 q[tail][0] = temp_y;
						 q[tail][1] = temp_x;
						 q[tail][2] = key;
					 }
					 else if(c >= 'a' && c <= 'z') {
						 flag[temp_y][temp_x][key|1<<(c-'a')] = 1;
						 count[temp_y][temp_x][key|1<<(c-'a')] = count[y][x][key]+1;
						 tail++;
						 q[tail][0] = temp_y;
						 q[tail][1] = temp_x;
						 q[tail][2] = key|1<<(c-'a');
					 }
					 else if(c == '1') {
						 System.out.println(count[y][x][key]+1);
						 return;
					 }
					 else {
						 flag[temp_y][temp_x][key] = 1;
						 count[temp_y][temp_x][key] = count[y][x][key]+1;
						 tail++;
						 q[tail][0] = temp_y;
						 q[tail][1] = temp_x;
						 q[tail][2] = key;
					 }
				}
			}
			
		}
		System.out.println(-1);
	}

}
