package com.not.solve;

import java.util.Scanner;

public class Xbj10866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] deque = new int[n];
		int front = 0;
		int back = -1;
		int count = 0;
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			int num;
			switch(s) {
			case "push_front":
				num = sc.nextInt();
				if(front < 0) front = n - 1;
				if(front == back) {
					System.out.println("Deque is full");
					break;
				}
				deque[front--] = num;
				count++;
				break;
			case "push_back":
				num = sc.nextInt();
				if(back > n - 1) back = 0;
				if(back == front) {
					System.out.println("Deque is full");
					break;
				}
				deque[back++] = num;
				count++;
				break;
			case "pop_front":
				if(front == n) front = 0;
				if(front == back) {
					System.out.println(-1);
					break;
				}
				System.out.println(deque[++front]);
				count--;
				break;
			case "pop_back":
				if(back == -1) back = n - 1;
				if(back == front) {
					System.out.println(-1);
					break;
				}
				System.out.println(deque[--back]);
				count--;
				break;
			case "size":
				System.out.println(count);
				break;
			case "empty":
				if(front - 1 == back) System.out.println(1);
				else System.out.println(0);
				break;
			case "front":
				if(front - 1 == back) System.out.println(-1);
				else System.out.println(deque[front]);
				break;
			case "back":
				if(front - 1 == back) System.out.println(-1);
				else System.out.println(deque[back]);
				break;
				default:
					break;
			}
		}
	}

}
