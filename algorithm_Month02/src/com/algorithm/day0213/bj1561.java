package com.algorithm.day0213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1561 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int m;
	static int[] arr;
	static long max=2000000000*30L;
	public static void main(String[] args) throws IOException {
		String str;
		StringTokenizer st;
		str=br.readLine();
		st=new StringTokenizer(str);
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[m];
		str=br.readLine();
		st=new StringTokenizer(str);
		for(int i=0;i<m;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		if(n<=m) {
			System.out.println(n);
			return;
		}
		long start=1;
		long end=max;
		while(true) {
			
		}
	}
}
