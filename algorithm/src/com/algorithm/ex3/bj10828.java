package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10828 {	// Ω∫≈√

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stack = new int[10001];
		int top = -1;
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			String t = st.nextToken();
			if(t.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				stack[++top] = x;
			}
			else if(t.equals("pop")) {
				if(top == -1) System.out.println(-1);
				else System.out.println(stack[top--]);
			}
			else if(t.equals("size")) {
				System.out.println(top+1);
			}
			else if(t.equals("empty")) {
				System.out.println(top==-1?1:0);
			}
			else if(t.equals("top")) {
				if(top == -1) System.out.println(-1);
				else System.out.println(stack[top]);
			}
		}
	}

}
