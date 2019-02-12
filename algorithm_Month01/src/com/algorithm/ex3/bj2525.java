package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj2525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s = br.readLine();
		st = new StringTokenizer(s);
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine());
		int ta = c/60;
		int tb = c%60;
		b+=tb;
		if(b>=60) {
			b-=60;
			a+=1;
		}
		a+=ta;
		if(a>=24) {
			a-=24;
		}
		bw.write(""+a+" "+b);
		bw.flush();
		bw.close();
		br.close();
	}

}
