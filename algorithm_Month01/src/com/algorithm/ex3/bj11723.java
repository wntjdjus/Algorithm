package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int arr = 0;
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			String s1 = st.nextToken();
			int x;
			if(s1.equals("add")) {
				x = Integer.parseInt(st.nextToken());
				arr = arr|1<<x;
			}
			else if(s1.equals("remove")) {
				x = Integer.parseInt(st.nextToken());
				arr = arr&~(1<<x);
			}
			else if(s1.equals("check")) {
				x = Integer.parseInt(st.nextToken());
				if((arr&1<<x)!=0) {
					bw.write(""+1+"\n");
				}
				else {
					bw.write(""+0+"\n");
				}
			}
			else if(s1.equals("toggle")) {
				x = Integer.parseInt(st.nextToken());
				if((arr&1<<x)!=0) arr = arr&~(1<<x);
				else arr = arr|1<<x;
			}
			else if(s1.equals("all")) {
				arr = (1<<21) - 1;
			}
			else if(s1.equals("empty")) {
				arr = 0;
			}
		}
		bw.flush();
		bw.close();
	}

}
