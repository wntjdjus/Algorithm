package com.algorithm.day0116;

import java.util.Scanner;

public class bj1935 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] alpha = new double[26];
		String s = sc.next();
		double[] stack = new double[s.length()];
		int top = -1;
		for(int i = 0; i < n; i++) {
			alpha[i] = (double)sc.nextInt();
		}
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				double temp = alpha[c-'A'];
				stack[++top] = temp;
			}
			else {
				double a = stack[top--];
				double b = stack[top--];
				switch(c) {
				case '+':
					stack[++top] = b+a;
					break;
				case '-':
					stack[++top] = b-a;
					break;
				case '*':
					stack[++top] = b*a;
					break;
				case '/':
					stack[++top] = b/a;
					break;
					default:
						break;
				}
			}
		}
		String answer = String.format("%.2f", stack[top]);
		System.out.println(answer);
	}

}
