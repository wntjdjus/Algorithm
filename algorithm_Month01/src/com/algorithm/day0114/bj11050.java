package com.algorithm.day0114;

import java.util.Scanner;

public class bj11050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int temp = Func(n,k);
		System.out.println(temp);
	}
	public static int Func(int n, int k) {
		if(n == k) return 1;
		if(k == 0) return 1;
		return Func(n-1,k-1) + Func(n-1,k);
	}

}
