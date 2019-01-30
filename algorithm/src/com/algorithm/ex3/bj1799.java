package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1799 {	// ºñ¼ó
	static int[] dx= {-1,1};
	static int[] dy= {1,-1};
	static int[][] arr;
	static int[][] shop;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		shop=new int[n][n];
		for(int i=0;i<n;i++) {
			String s=br.readLine();
			st=new StringTokenizer(s);
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
