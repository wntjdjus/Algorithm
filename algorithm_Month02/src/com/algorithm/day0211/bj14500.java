package com.algorithm.day0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj14500 {
	static int[][] arr;
	static int n;
	static int m;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String str=br.readLine();
		st=new StringTokenizer(str);
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[n][m];
		for(int i=0;i<n;i++) {
			str=br.readLine();
			st=new StringTokenizer(str);
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int max=0;
		int[][] visit=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				//visit=new int[n][m];
				int a;
				a=dfs(i,j,1,0,visit);
				max=max>a?max:a;
				a=func(i,j,visit);
				max=max>a?max:a;
			}
		}
		bw.write(max+"");
		bw.flush();
		bw.close();
		br.close();
	}
	public static int dfs(int y,int x,int nn,int sum,int[][] visit) {
		sum+=arr[y][x];
		if(nn==4) {
			return sum;
		}
		visit[y][x]=1;
		int max=0;
		for(int d=0;d<4;d++) {
			int tx=x+dx[d];
			int ty=y+dy[d];
			if(tx<0||tx>=m||ty<0||ty>=n) continue;
			if(visit[ty][tx]==1) continue;
			int t=dfs(ty,tx,nn+1,sum,visit);
			max=max>t?max:t;
		}
		visit[y][x]=0;
		return max;
	}
	public static int func(int y,int x,int[][] visit) {
		int max=0;
		int t;
		if(y+1<n&&x-1>=0&&x+1<m) {
			//で
			t=arr[y][x]+arr[y+1][x-1]+arr[y+1][x]+arr[y+1][x+1];
			max=max>t?max:t;
		}
		if(x+2<m&&y+1<n) {
			//ぬ
			t=arr[y][x]+arr[y][x+1]+arr[y][x+2]+arr[y+1][x+1];
			max=max>t?max:t;
		}
		if(y+2<n&&x+1<m) {
			//た
			t=arr[y][x]+arr[y+1][x]+arr[y+2][x]+arr[y+1][x+1];
			max=max>t?max:t;
		}
		if(y-1>=0&&y+1<n&&x+1<m) {
			//っ
			t=arr[y][x]+arr[y-1][x+1]+arr[y][x+1]+arr[y+1][x+1];
			max=max>t?max:t;
		}
		return max;
	}
}
