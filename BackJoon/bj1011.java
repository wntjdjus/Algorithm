package com.algorithm.code;

import java.util.Scanner;

public class bj1011 {
	
	/**
	 * 1. X보다 작은 제곱 수 구하기
	 * 2. 제곱 수 -> 루트화 ==> K  -> 횟수에 더하기
	 * 3. X - 제곱수 = M
	 * 4. M / K -> K * A + B  ===> A + n(B) -> 횟수에 더하기 
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 0; t < test; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int num = y - x;
			int count = 0;
			int k = (int)Math.sqrt(num);
			count += (2 * k - 1);
			int m = num - k * k;
			int temp = m / k;
			count += temp;
			if(m % k != 0) {
				count += 1;
			}
			System.out.println(count);
		}
	}

}
