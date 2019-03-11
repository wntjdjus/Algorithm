package com.algorithm.day0219;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj2869 {	// 달팽이는 오르고싶다. 이분탐색
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int v=Integer.parseInt(st.nextToken());
		int c=a-b;
		long low=0;
		long high=1000000000;
		long mid=0;
		while(low!=high) {
			mid=(low+high)>>1;
			if(c*mid+a>=v) high=mid;
			else low=mid+1;
		}
		bw.write((low+1)+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
