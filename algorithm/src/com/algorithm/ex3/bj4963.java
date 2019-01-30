package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj4963 {	// ¼¶ÀÇ °³¼ö
	static int[] dx= {-1,0,1,-1,0,1,-1,0,1};
	static int[] dy= {-1,-1,-1,0,0,0,1,1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		while(true) {
			String s = br.readLine();
			st=new StringTokenizer(s);
			int w=Integer.parseInt(st.nextToken());
			int h=Integer.parseInt(st.nextToken());
			if(w==0&&h==0)break;
			int[][] arr=new int[h][w];
			int[][] check=new int[h][w];
			int count=0;
			for(int i=0;i<h;i++) {
				s=br.readLine();
				st=new StringTokenizer(s);
				for(int j=0;j<w;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(check[i][j]==1||arr[i][j]==0)continue;
					count++;
					dfs(arr,check,h,w,i,j);
				}
			}
			bw.write(""+count+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void dfs(int[][] arr, int[][] check,int h, int w, int i,int j) {
		check[i][j]=1;
		for(int d=0;d<9;d++) {
			int tx=j+dx[d];
			int ty=i+dy[d];
			if(tx<0||tx>=w||ty<0||ty>=h) continue;
			if(arr[ty][tx]==1&&check[ty][tx]==0) {
				dfs(arr,check,h,w,ty,tx);
			}
		}
	}
}
