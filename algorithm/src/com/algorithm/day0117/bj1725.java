package com.algorithm.day0117;

import java.util.Scanner;

public class bj1725 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] stack = new int[n+2];
		int top = 0;
		int max = 0;
		stack[top] = 0;
		for(int i = 0; i <= n; i++) {
			int h;
			if(i == n) {
				h = 0;
			}
			else {
				h = sc.nextInt();
			}
			int index = top+1;
			while(stack[top] > h) {
				int temp = stack[top];
				temp = temp * (index-top);
				max = temp > max ? temp : max;
				stack[top] = h;
				top--;
			}
			stack[index] = h;
			top = index;
		}
		System.out.println(max);
	}

}
