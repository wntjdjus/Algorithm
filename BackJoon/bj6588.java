package com.algorithm.day0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj6588 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s;
		int[] so=new int[1000000+1];
		for(int i=2;i<=1000000;i++) {
			if(so[i]==-1)continue;
			int tnum=i;
			so[tnum]=1;
			while(true) {
				tnum+=i;
				if(tnum>1000000)break;
				so[tnum]=-1;
			}
		}
		while(true) {
			int t=Integer.parseInt(br.readLine());
			if(t==0)break;
//			for(int i=2;i<=t;i++) {
//				System.out.print(so[i]+" ");
//			}
			for(int i=3;i<=t;i++) {
				if(so[i]==-1)continue;
				if(so[t-i]==1) {
					bw.write(t+" = "+i+" + "+(t-i)+"\n");
					break;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
