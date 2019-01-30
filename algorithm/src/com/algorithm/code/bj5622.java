package com.algorithm.code;

import java.util.Scanner;

public class bj5622 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int[] arr = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		String s = sc.next();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int temp = arr[c-65];
			sum += temp;
			sum++;
		}
		System.out.println(sum);
	}

}
