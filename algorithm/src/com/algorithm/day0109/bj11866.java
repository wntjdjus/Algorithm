package com.algorithm.day0109;

import java.util.Scanner;

public class bj11866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] flag = new int[n+1];
		int[] su = new int[n];
		int index = 0;
		int count = 0;
		for(int i = 0; i < su.length; i++) {
			while(true) {
				index++;
				if(index > n) index -= n;
				if(flag[index] == 1) continue;
				count++;
				if(count == m) {
					su[i] = index;
					flag[index] = 1;
					count = 0;
					break;
				}
			}
		}
		System.out.print("<"+su[0]);
		for(int i = 1; i < n; i++) {
			System.out.print(", "+su[i]);
		}
		System.out.println(">");
	}

}
