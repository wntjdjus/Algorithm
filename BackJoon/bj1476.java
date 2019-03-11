package com.algorithm.day0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1476 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String str=br.readLine();
		st=new StringTokenizer(str, " ");
		int e=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int startE=1;
		int startS=1;
		int startM=1;
		int i=1;
		while(true) {
			if(startE==e&&startS==s&&startM==m) break;
			startE++;
			startS++;
			startM++;
			if(startE>15)startE=1;
			if(startS>28)startS=1;
			if(startM>19)startM=1;
			i++;
		}
		bw.write(i+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
