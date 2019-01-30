package com.not.solve;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class bj3108 {
//	static int[][] arr;
//	static int[] visit;
//	static int count;
//	static int n;

	public static void main(String[] args) throws IOException {
		int[][] arr;
		int[] visit;
		int count;
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] x1 = new int[1001];
		int[] x2 = new int[1001];
		int[] y1 = new int[1001];
		int[] y2 = new int[1001];
		arr = new int[n][n];
		visit = new int[n];
		count = 0;
		int flag = 0;
		for(int i = 0; i < n; i++) {
			x1[i] = sc.nextInt()+500;
			y1[i] = sc.nextInt()+500;
			x2[i] = sc.nextInt()+500;
			y2[i] = sc.nextInt()+500;
			if(x1[i] == 500 || x2[i] == 500) {
				if(y2[i] >= 500 && y1[i] <= 500) {
					if(flag == 0) {
						count--;
						flag = 1;
					}
				}
			}
			else if(y1[i] == 500 || y2[i] == 500) {
				if(x2[i] >= 500 && x1[i] <= 500) {
					if(flag == 0) {
						count--;
						flag = 1;
					}
				}
			}
		}
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				if(x1[i] > x2[j] || x2[i] < x1[j] || y1[i] > y2[j] || y2[i] < y1[j]) {
					continue;
				}
				if(x1[i] > x1[j] && x2[i] < x2[j] && y1[i] > y1[j] && y2[i] < y2[j]) {
					continue;
				}
				if(x1[i] < x1[j] && x2[i] > x2[j] && y1[i] < y1[j] && y2[i] > y2[j]) {
					continue;
				}
				arr[i][j] = 1;
				arr[j][i] = 1;
			}
		}
		for(int i = 0; i < n; i++) {
			if(visit[i] == 1) continue;
			count++;
			dfs(i,arr,visit, n);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(count+"\n");
		bw.flush();
		bw.close();
	}
	private static void dfs(int k, int[][] arr, int[] visit, int n) {
		if(visit[k] == 1) return;
		visit[k] = 1;
		for(int i = 0; i < n; i++) {
			if(arr[k][i] == 1 && visit[i] == 0) {
				dfs(i, arr, visit, n);
			}
		}
	}

}
