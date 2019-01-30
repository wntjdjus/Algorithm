package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj10872 {	// ÆÑÅä¸®¾ó

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int fact = 1;
		for(int i = 2; i <= n; i++) {
			fact *= i;
		}
		bw.write(""+fact);
		bw.flush();
		bw.close();
	}

}
