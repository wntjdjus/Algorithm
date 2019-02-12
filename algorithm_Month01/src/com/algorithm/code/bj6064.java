package com.algorithm.code;

import java.util.Scanner;

public class bj6064 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 0; t < test; t++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int count = x < y ? x : y;
			int temp_x = count, temp_y = count;
			int flag = 0;	
			int term = x < y ? m : n;
			
			int c = 1;
			int temp_m = m, temp_n = n;
			int i = 2;
			int min = temp_m < temp_n ? temp_m : temp_n;
			while(i <= min) {
				if(temp_m % i == 0 && temp_n % i == 0) {
					c *= i;
					temp_m /= i;
					temp_n /= i;
				}
				i++;
			}
			c *= temp_m;
			c *= temp_n;
			
			while(count <= c) {
				if(temp_x == x && temp_y == y) {
					flag = 1;
					break;
				}
				if(x < y) {
					temp_y += m;
					while(temp_y > y) {
						temp_y -= n;
					}
				}
				else {
					temp_x += n;
					while(temp_x > m) {
						temp_x -= m;
					}
				}
				count += term;
			}
			if(flag == 1) {
				System.out.println(count);
			}
			else {
				System.out.println(-1);
			}
		}
	}

}
