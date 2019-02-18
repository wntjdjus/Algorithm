package com.algorithm.day0214;

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
		arr=new int[m+1];
		str=br.readLine();
		st=new StringTokenizer(str);
		for(int i=1;i<=m;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		if(n<=m) {
			System.out.println(n);
			return;
		}
		long start=0;
		long end=max;
		while(start!=end-1) {
			long mid=(start+end)>>1;
			long count=m;
			for(int i=1;i<=m;i++) {
				count+=(mid/arr[i]);
			}
			if(count>=n) end=mid;
			else if(count<n) start=mid;
		}
		long tcount=m;
		for(int i=1;i<=m;i++) {
			tcount+=(start/arr[i]);
		}
		tcount=n-tcount;
		for(int i=1;i<=m;i++) {
			if((start+1)%arr[i]==0)tcount--;
			if(tcount==0) {
				bw.write(""+i);
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
