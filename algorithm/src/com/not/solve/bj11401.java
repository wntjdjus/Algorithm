package com.not.solve;

import java.util.Scanner;

public class bj11401 {
	/*
	 * ���װ��
- Ȯ�� ��Ŭ���� �˰���

1. nCk = n! / k!(n-k)!

n! = A	k!(n-k)! = B	p = 1000000007

answer = (AB^-1) % p

* ���� �׵�� ==> �� ���� �ִ� ������� ���� �� ���� ����� ������ ��Ÿ�� �� �ִ�.

p�� �Ҽ��̱� ������ B�� p�� ���μ� ����

--> Bx + py = 1

2. (Bx + py) % p = 1 % p --> 1 mod p

==> Bx = 1 (mod p)

3. (AB^-1) % p = (AB^-1 * 1) % p = (AB^-1 * Bx) % p = Ax % p

Solution
x�� ���ؼ� Ax % p�� �Ѵ�.

gcd(B,p) --> gcd(1,0)
x = 1, y = 0  --> x' = y, y' = 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int p = 1000000007;
		int[] fact = new int[n+1];
		fact[1] = 1;
		for(int i = 2; i <= n; i++) {
			fact[i] = (fact[i-1] * i) % p;
		}
		int B = (fact[k] * fact[n-k]) % p;
		
	}
}