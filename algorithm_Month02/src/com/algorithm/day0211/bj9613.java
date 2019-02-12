package com.algorithm.day0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj9613 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int test=Integer.parseInt(br.readLine());
		for(int t=0;t<test;t++) {
			String str=br.readLine();
			st=new StringTokenizer(str);
			int n=Integer.parseInt(st.nextToken());
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			long sum=0L;
			if(n==1) sum=arr[0];
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					int gcd=1;
					int big=arr[i]>arr[j]?arr[i]:arr[j];
					int small=arr[i]<arr[j]?arr[i]:arr[j];
					int mul=small;
					while(true) {
						if(mul==1) {
							break;
						}
						if(big%mul==0&&small%mul==0) {
							big/=mul;
							small/=mul;
							gcd*=mul;
							mul=small;
						}
						else {
							mul--;
						}
					}
					sum+=gcd;
				}
			}
			bw.write(sum+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
