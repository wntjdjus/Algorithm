package com.algorithm.code;

import java.util.Scanner;

public class bj10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 0; t < test; t++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			
			int x = n / h + 1;
			int y = n % h;
			if(y == 0) {
				y = h;
				x -= 1;
			}
			System.out.print(y);
			if(x < 10) {
				System.out.print("0");
			}
			System.out.println(x);
		}
	}

}
