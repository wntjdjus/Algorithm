package com.algorithm.code;

import java.util.Scanner;

public class bj1316 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int[] check = new int[26]; // alpabet - 97
			String s = sc.next();
			char c = s.charAt(0);
			check[c-97]++;
			int flag = 1;
			for(int j = 1; j < s.length(); j++) {
				c = s.charAt(j);
				if(s.charAt(j-1) != c) {
					if(check[c-97] == 1) {
						flag = 0;
						break;
					}
					check[c-97] = 1;
				}
			}
			if(flag == 1) {
				count++;
			}
		}
		System.out.println(count);
	}

}
