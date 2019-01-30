package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj7576 {
	static class tomato{
		int x;
		int y;
		int day;
		public tomato(int y, int x, int day){
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		int[][] arr = new int[n][m];
		int[][] flag = new int[n][m];
		int tomato_num = 0;
		tomato[] tq = new tomato[n*m+1];
		int front = -1;
		int rear = -1;
		for(int i = 0; i < n; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) tomato_num++;
				else if(arr[i][j] == 1) {
					tomato to = new tomato(i,j,0);
					tq[++rear] = to;
					flag[i][j] = 1;
				}
			}
		}
		if(tomato_num == 0) {
			System.out.println(0);
			return;
		}
		while(front != rear) {
			tomato toto = tq[++front];
			for(int k = 0; k < 4; k++) {
				int tx = toto.x+dx[k];
				int ty = toto.y+dy[k];
				int tday = toto.day+1;
				if(tx>=0&&tx<m&&ty>=0&&ty<n) {
					if(flag[ty][tx] == 1) continue;
					if(arr[ty][tx] != 0) continue;
					flag[ty][tx] = 1;
					tomato_num--;
					tq[++rear] = new tomato(ty,tx,tday);
					if(tomato_num == 0) {
						System.out.println(tday);
						return;
					}
				}
			}
		}
		System.out.println(-1);
	}

}
