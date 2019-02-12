package com.algorithm.day0212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4485 {
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[][] arr;
	static int[][] dp;
	static int[][] flag;
	static boolean[][] visit;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static int n;
	static int min=Integer.MAX_VALUE;
	static int count=0;
	static Queue<int,int> 
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t=0;
		while(true) {
			t++;
			StringTokenizer st;
			n=Integer.parseInt(br.readLine());
			if(n==0)break;
			arr=new int[n][n];
			dp=new int[n][n];
			flag=new int[n][n];
			visit=new boolean[n][n];
			for(int i=0;i<n;i++) {
				String str=br.readLine();
				st=new StringTokenizer(str);
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			flag[0][0]=1;
			dp[0][0]=arr[0][0];
			dfs(n-1,n-1);
			bw.write("Problem "+t+": "+dp[n-1][n-1]+"\n");
			System.out.println(count);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void dfs(int y,int x) {
		int min=Integer.MAX_VALUE;
		count++;
		visit[y][x]=true;
		for(int d=0;d<4;d++) {
			int tx=x+dx[d];
			int ty=y+dy[d];
			if(tx<0||tx>=n||ty<0||ty>=n) continue;
			if(visit[ty][tx]) continue;
			if(flag[ty][tx]==0) {
				dfs(ty,tx);
			}
			min=min<dp[ty][tx]?min:dp[ty][tx];
		}
		dp[y][x]=min+arr[y][x];
		flag[y][x]=1;
		visit[y][x]=false;
	}
}
