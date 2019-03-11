package com.algorithm.day0110;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.IOException;

public class bj11729 {
	
	private static void Hanoi(int n, int start, int end, int temp, BufferedWriter bw) throws IOException{
		if(n == 0) return;
		Hanoi(n-1,start,temp,end, bw);
		bw.write(start+" "+end+"\n");
		Hanoi(n-1,temp,end,start, bw);
	}

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = (1 << n) - 1;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//bw.write(s);
		bw.write(count+"\n");
		Hanoi(n,1,3,2,bw);
		bw.flush();
		bw.close();
	}

}
