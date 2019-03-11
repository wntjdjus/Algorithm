package com.algorithm.code;

import java.util.Scanner;

public class bj1011 {
	
	/**
	 * 1. X���� ���� ���� �� ���ϱ�
	 * 2. ���� �� -> ��Ʈȭ ==> K  -> Ƚ���� ���ϱ�
	 * 3. X - ������ = M
	 * 4. M / K -> K * A + B  ===> A + n(B) -> Ƚ���� ���ϱ� 
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
