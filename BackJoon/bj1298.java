package com.algorithm.day0213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1298 {	
	// [노트북의 주인을 찾아서]
	// 이분매칭
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int m;
	static boolean[][] connect;
	static int[] matchA;
	static int[] matchB;
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		String str;
		str=br.readLine();
		st=new StringTokenizer(str);
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		connect=new boolean[n+1][n+1];
		matchA=new int[n+1];
		matchB=new int[n+1];
		for(int i=0;i<m;i++) {
			str=br.readLine();
			st=new StringTokenizer(str);
			int person=Integer.parseInt(st.nextToken());
			int com=Integer.parseInt(st.nextToken());
			connect[person][com]=true;
		}
		int result=matching();
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
	public static int matching() {
		int count=0;
		boolean[] visit;
		for(int a=1;a<=n;a++) {
			visit=new boolean[n+1];
			if(dfs(a,visit))count++;
		}
		return count;
	}
	public static boolean dfs(int a,boolean[] visit) {
		for(int b=1;b<=n;b++) {
			if(!connect[a][b]||visit[b])continue;
			visit[b]=true;
			if(matchB[b]==0||dfs(matchB[b],visit)) {
				matchA[a]=b;
				matchB[b]=a;
				return true;
			}
		}
		return false;
	}
}
