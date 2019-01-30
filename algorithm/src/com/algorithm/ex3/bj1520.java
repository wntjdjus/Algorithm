package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1520 {
	static int count =0;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static int n;
	static int m;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s=br.readLine();
		st=new StringTokenizer(s);
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		arr=new int[m][n];
		dp=new int[m][n];
		for(int i=0;i<m;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=1;
		dfs(m-1,n-1);
		bw.write(""+dp[m-1][n-1]);
		bw.flush();
		bw.close();
		br.close();
	}
	public static void dfs(int i, int j) {
		for(int d=0;d<4;d++) {
			int tx=j+dx[d];
			int ty=i+dy[d];
			if(tx<0||tx>=n||ty<0||ty>=m) continue;
			if(arr[ty][tx]>arr[i][j]) {
				if(dp[ty][tx]==0)dfs(ty,tx);
				if(dp[ty][tx]==-1)continue;
				dp[i][j]+=dp[ty][tx];
			}
		}
		if(dp[i][j]==0) {
			dp[i][j]=-1;
		}
	}
}
