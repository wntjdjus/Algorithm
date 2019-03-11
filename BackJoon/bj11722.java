package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj11722 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] result = new int[n];
		int index = -1;
		int end = 0;
		String s = br.readLine();
		st = new StringTokenizer(s);
		int num = Integer.parseInt(st.nextToken());
		result[++index]=num;
		for(int i = 1; i < n; i++) {
			num=Integer.parseInt(st.nextToken());
			if(result[index]>num) result[++index]=num;
			else {
				int tindex = index;
				while(tindex!=-1) {
					if(result[tindex]<=num)tindex--;
					else break;
				}
				result[++tindex]=num;
			}
		}
		bw.write(""+(index+1));
		bw.flush();
		bw.close();
	}

}
