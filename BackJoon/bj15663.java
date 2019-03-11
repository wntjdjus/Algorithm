package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15663 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] arr;
	static int[] visit;		// 인덱스 방문여부 체크
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		arr=new int[n];
		visit=new int[n];
		s=br.readLine();
		st=new StringTokenizer(s);
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[] result=new int[m];
		Arrays.sort(arr);
		dfs(n,m,0,result);
		bw.flush();
		bw.close();
		br.close();
	}
	private static void dfs(int n, int m, int count, int[] result) throws IOException {
		if(count==m) {
			for(int i=0;i<m;i++) {
				bw.write(result[i]+" ");
			}
			bw.write("\n");
			return;
		}
		int[] check=new int[10001];  // 같은 위치에 같은 수 두 번 부르지 않게 체크
		for(int i=0;i<n;i++) {
			if(visit[i]==0&&check[arr[i]]==0) {
				visit[i]=1;
				check[arr[i]]=1;
				result[count]=arr[i];
				dfs(n,m,count+1,result);
				visit[i]=0;
			}
		}
	}

}
