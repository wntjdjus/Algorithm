package com.not.solve;

import java.util.Scanner;

public class bj11401 {
	/*
	 * 이항계수
- 확장 유클리드 알고리즘

1. nCk = n! / k!(n-k)!

n! = A	k!(n-k)! = B	p = 1000000007

answer = (AB^-1) % p

* 베주 항등식 ==> 두 수의 최대 공약수는 원래 두 수의 배수의 합으로 나타낼 수 있다.

p가 소수이기 때문에 B와 p는 서로소 관계

--> Bx + py = 1

2. (Bx + py) % p = 1 % p --> 1 mod p

==> Bx = 1 (mod p)

3. (AB^-1) % p = (AB^-1 * 1) % p = (AB^-1 * Bx) % p = Ax % p

Solution
x를 구해서 Ax % p를 한다.

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