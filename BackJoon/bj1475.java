package com.algorithm.code;

import java.util.Scanner;

public class bj1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		String s = sc.next();
		for(int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - 48;
			arr[num]++;
		}
		arr[6] += arr[9];
		arr[6] = (arr[6] + 1) / 2;
		int min = 0;
		for(int i = 0; i <= 8; i++) {
			if(arr[i] > min) {
				min = arr[i];
			}
		}
		System.out.println(min);
	}
	
}
