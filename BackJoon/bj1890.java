package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1890 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		int[][] arr=new int[n][n];
		long[][] dp=new long[n][n];
		int[] dx= {1,0};
		int[] dy= {0,1};
		for(int i=0;i<n;i++) {
			String s=br.readLine();
			st=new StringTokenizer(s);
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=1;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) {
				if(i==n-1&&j==n-1)continue;
				if(dp[i][j]==0)continue;
				for(int d=0;d<2;d++) {
					int tx=j+dx[d]*arr[i][j];
					int ty=i+dy[d]*arr[i][j];
					if(tx<0||tx>=n||ty<0||ty>=n) continue;
					dp[ty][tx]+=dp[i][j];
				}
			}
		}
		bw.write(""+dp[n-1][n-1]);
		bw.flush();
		bw.close();
		br.close();
	}

}
