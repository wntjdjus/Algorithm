package com.algorithm.day0114;

import java.util.Scanner;

public class bj3053 {
	static double pi = 3.14159265358979323846;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		double n1 = r*r*pi;
		double n2 = r*r*2;
		System.out.println(n1);
		System.out.println(n2);
	}

}
