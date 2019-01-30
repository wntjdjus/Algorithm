package com.not.solve;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class bj15649 {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Func(n, m, bw);
		
		bw.flush();
		bw.close();
	}
	private static void Func(int n, int m, BufferedWriter bw) throws IOException{
		
	}
}
