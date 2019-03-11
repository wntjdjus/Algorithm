package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2667 {
	static int n;
	static int[][] arr;
	static int[][] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		flag = new int[n][n];
		int number = 0;
		int[] home = new int[626];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j]==1&&flag[i][j]==0) {
					flag[i][j] = 1;
					int temp = dfs(i,j);
					home[number++] = temp;
				}
			}
		}
		Arrays.sort(home, 0, number);
		System.out.println(number);
		for(int i = 0; i < number; i++) {
			System.out.println(home[i]);
		}
	}
	public static int dfs(int i, int j) {
		int a = 1;
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		for(int d = 0; d < 4; d++) {
			if(i+dy[d]>=0&&i+dy[d]<n&&j+dx[d]>=0&&j+dx[d]<n) {
				if(arr[i+dy[d]][j+dx[d]]==1&&flag[i+dy[d]][j+dx[d]]==0) {
					flag[i+dy[d]][j+dx[d]] = 1;
					a += dfs(i+dy[d],j+dx[d]);
				}
			}
		}
		return a;
	}
}
