package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj2178 {
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static int[][] arr;
	static int[][] dp;
	static int n;
	static int m;
	static int[][] q;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s;
		s=br.readLine();
		st=new StringTokenizer(s);
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[n][m];
		dp=new int[n][m];
		q=new int[n*m][2];
		int front=-1;
		int rear=-1;
		int[][] visit=new int[n][m];
		for(int i=0;i<n;i++) {
			s=br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}
		dp[0][0]=1;
		visit[0][0]=1;
		rear++;
		q[rear][0]=0;
		q[rear][1]=0;
		while(front!=rear) {
			front++;
//			bfs(q[front][0],q[front][1],visit);
			int x=q[front][1];
			int y=q[front][0];
			for(int d=0;d<4;d++) {
				int tx=x+dx[d];
				int ty=y+dy[d];
				if(tx<0||tx>=m||ty<0||ty>=n) continue;
				if(arr[ty][tx]==1&&visit[ty][tx]==0) {
					visit[ty][tx]=1;
					dp[ty][tx]=dp[y][x]+1;
					rear++;
					q[rear][0]=ty;
					q[rear][1]=tx;
				}
			}
		}
		bw.write(""+dp[n-1][m-1]);
		bw.flush();
		bw.close();
		br.close();
	}

}
