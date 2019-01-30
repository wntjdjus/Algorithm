package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj2439{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] stack = new int[n+1];
		int top = -1;
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		stack[++top] = 1;
		bw.write(""+0);
		for(int i = 2; i <= n; i++) {
			while(top!=-1) {
				if(arr[stack[top]] < arr[i]) {
					top--;
				}
				else {
					bw.write(" "+stack[top]);
					stack[++top] = i;
					break;
				}
			}
			if(top == -1) {
				bw.write(" "+0);
				stack[++top] = i;
			}
		}
		bw.flush();
		bw.close();
	}

}
