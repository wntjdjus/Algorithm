package com.algorithm.code;

import java.util.Scanner;

public class bj2504 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] stack = new int[31];
		int top = 0;
		int sum = 0;
		for(int i = 0; i < s.length(); i++) {
			int temp = 0;
			switch(s.charAt(i)) {
			case '(':
				stack[++top] = -2;
				break;
			case '[':
				stack[++top] = -3;
				break;
			case ')':
				while(stack[top] != -2) {
					temp += stack[top--];
					if(top == -1) {
						System.out.println(0);
						return;
					}
				}
				if(temp == 0) stack[top] = 2;
				else stack[top] = 2 * temp;
				break;
			case ']':
				while(stack[top] != -3) {
					temp += stack[top--];
					if(top == -1) {
						System.out.println(0);
						return;
					}
				}
				if(temp == 0) stack[top] = 3;
				else stack[top] = 3 * temp;
				break;
				default:
					System.out.println(0);
					return;
			}
		}
		while(top != 0) {
			if(stack[top] < 0) {
				System.out.println(0);
				return;
			}
			sum += stack[top--];
		}
		System.out.println(sum);
	}

}
