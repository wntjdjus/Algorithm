package com.algorithm.code;

import java.util.Scanner;

public class bj2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String s = sc.next();
		for(int i = 0; i < s.length(); i++) {
			if(i == s.length() - 1) {
				count++;
				break;
			}
			char c = s.charAt(i);
			switch(c) {
			case 'c':
				if(s.charAt(i+1) == '=' || s.charAt(i+1) == '-') {
					i++;
				}
				break;
			case 'd':
				if(s.charAt(i+1) == 'z') {
					if(s.charAt(i+2) == '=') {
						i += 2;
					}
				}
				else if(s.charAt(i+1) == '-') {
					i++;
				}
				break;
			case 'l':
				if(s.charAt(i+1) == 'j') {
					i++;
				}
				break;
			case 'n':
				if(s.charAt(i+1) == 'j') {
					i++;
				}
				break;
			case 's':
				if(s.charAt(i+1) == '=') {
					i++;
				}
				break;
			case 'z':
				if(s.charAt(i+1) == '=') {
					i++;
				}
				break;
				default:
					break;
			}
			count++;
		}
		System.out.println(count);
	}

}
