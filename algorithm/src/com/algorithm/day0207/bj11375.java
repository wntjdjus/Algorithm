package com.algorithm.day0207;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj11375 {
	static int n;
	static int m;
	static boolean[][] connect;
	static int[] matchA;
	static int[] matchB;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String str=br.readLine();
		st=new StringTokenizer(str);
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		connect=new boolean[n+1][m+1];
		matchA=new int[n+1];
		matchB=new int[m+1];
		for(int i=1;i<=n;i++) {
			str=br.readLine();
			st=new StringTokenizer(str);
			int jobNum=Integer.parseInt(st.nextToken());
			for(int j=0;j<jobNum;j++) {
				int job=Integer.parseInt(st.nextToken());
				connect[i][job]=true;
			}
		}
		int max=go();
		bw.write(max+"");
		bw.flush();
		bw.close();
		br.close();
	}
	public static int go() {
		boolean[] visit;
		int max=0;
		for(int a=1;a<=n;a++) {
			visit=new boolean[n+1];
			if(dfs(a,visit)) max++;
		}
		return max;
	}
	public static boolean dfs(int a, boolean[] visit) {
		if(visit[a]) return false;
		visit[a]=true;
		for(int b=1;b<=m;b++) {
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
