package com.algorithm.day0218;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1799 {	// ºñ¼ó		ÀÌºÐ¸ÅÄª
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int x;
	static int y;
	static int[][] check;
	static int[][] arrA;
	static int[][] arrB;
	static boolean[][] connect;
	static int[] matchA;
	static int[] matchB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		n=Integer.parseInt(br.readLine());
		y=n+n;
		x=n;
		check=new int[y][x];
		arrA=new int[y][x];
		arrB=new int[y][x];
		connect=new boolean[y+x][y];
		matchA=new int[y+x];
		matchB=new int[y];
		for(int i=n;i<y;i++) {			// y' : n~y-1 , x' : 0~x-1
			String str=br.readLine();
			StringTokenizer st=new StringTokenizer(str);
			for(int j=0;j<x;j++) {
				check[i][j]=Integer.parseInt(st.nextToken());
				if(check[i][j]==1) connect[i+j][i-j]=true;
			}
		}
		int result=go();
		bw.write(""+result);
		bw.flush();
		bw.close();
		br.close();
	}
	public static int go() {
		int sum=0;
		boolean[] visit;
		for(int a=n;a<y+x-1;a++) {
			visit=new boolean[y+x-1];
			if(dfs(a,visit)) sum++;
		}
		return sum;
	}
	public static boolean dfs(int a, boolean[] visit) {
		if(visit[a]) return false;
		visit[a]=true;
		for(int b=1;b<y;b++) {
			if(connect[a][b]) {
				if(matchB[b]==0||dfs(matchB[b],visit)) {
					matchA[a]=b;
					matchB[b]=a;
					return true;
				}
			}
		}
		return false;
	}
}
