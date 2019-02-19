package com.algorithm.day0219;

import java.util.Scanner;

public class bj11401 {
	static long[] fact;
	static int p;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		p=1000000007;
		fact=new long[n+1];
		fact[0]=1;
		for(int i=1;i<=n;i++) {
			fact[i]=(fact[i-1]*i)%p;
		}
		long result=(((fact[n]*func(fact[n-k],p-2))%p)*func(fact[k],p-2))%p;
		System.out.println(result);
	}
	public static long func(long a, int k) {
		long sum=1;
		while(k!=1) {
			if(k%2!=0) sum=(sum*a)%p;
			a=(a*a)%p;
			k=k>>1;
		}
		sum=(sum*a)%p;
		return sum;
	}
}
