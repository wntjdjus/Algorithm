package com.algorithm.code;

import java.util.Scanner;

public class bj10799 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int count = 0, flag = 0, num = 0;
		for(int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			switch(temp) {
			case '(':
				count++;
				flag = 0;
				break;
			case ')':
				if(flag == 0) {
					count--;
					num += count;
				}
				else {
					num += 1;
					count--;
				}
				flag = 1;
				break;
				default:
					break;
			}
		}
		System.out.println(num);
	}

}
