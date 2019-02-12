package com.algorithm.day0116;

import java.util.Scanner;

public class bj1918 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] stack1 = new char[s.length()+1];
		char[] stack2 = new char[s.length()+1];
		int top1 = -1;
		int top2 = -1;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				stack1[++top1] = c;
			}
			else {
				if(top2 == -1) {
					stack2[++top2] = c;
				}
				else {
					if(c == '+' || c == '-') {
						while(top2 != -1 && stack2[top2] != '(') {
							stack1[++top1] = stack2[top2--];
						}
						stack2[++top2] = c;	
					}
					else if(c == '*' || c == '/') {
						while(top2 != -1 && (stack2[top2] == '*' || stack2[top2] == '/')) {
							stack1[++top1] = stack2[top2--];
						}
						stack2[++top2] = c;	
					}
					else if(c == ')') {
						while(stack2[top2] != '(') {
							stack1[++top1] = stack2[top2--];
						}
						top2--;							
					}
					else {
						stack2[++top2] = c;						
					}
				}
			}
		}
		while(top2 != -1) {
			stack1[++top1] = stack2[top2--];
		}
		for(int i = 0; i <= top1; i++) {
			System.out.print(stack1[i]);
		}
	}

}
