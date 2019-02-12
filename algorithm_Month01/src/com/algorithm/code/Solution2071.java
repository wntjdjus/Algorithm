package com.algorithm.code;

import java.util.Scanner;

public class Solution2071 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Case = sc.nextInt();
		for(int i = 1; i <= Case; i++) {
			int t, sum = 0;
			int avg;
			for(int j = 0; j < 10; j++) {
				t = sc.nextInt();
				sum += t;
			}
			avg = (int)Math.round(sum / 10.0);
			
			System.out.println("#"+i+" "+avg);
		}
		
		
	}

}
