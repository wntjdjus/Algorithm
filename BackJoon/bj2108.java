package com.algorithm.code;

import java.util.Arrays;
import java.util.Scanner;

public class bj2108 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] plus = new int[4001];
		int[] minus = new int[4001];
		int flag = -1;
		int sum = 0;
		double avg = 0.0;
		int center = 0;
		int many = 0;
		int many_num = 0;
		int su = 0;
		int range = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			if(arr[i] >= 0) {
				plus[arr[i]]++;
				if(plus[arr[i]] > many_num) {
					many_num = plus[arr[i]];
				}
			}
			else {
				minus[Math.abs(arr[i])]++;
				if(minus[Math.abs(arr[i])] > many_num) {
					many_num = minus[Math.abs(arr[i])];
				}
			}
		}
		avg = (double)sum / arr.length;
		Arrays.sort(arr);
		int t = arr.length / 2;
		center = arr[t];
		int temp = 0;
		while(true) {
			for(int i = 4000; i > 0; i--) {
				if(minus[i] == many_num) {
					temp++;
					many = i;
					flag = -1;
				}
				if(temp == 2) {
					break;
				}
			}
			if(temp == 2) {
				break;
			}
			for(int i = 0; i <= 4000; i++) {
				if(plus[i] == many_num) {
					temp++;
					many = i;
					flag = 1;
				}
				if(temp == 2) {
					break;
				}
			}
			if(temp == 2) {
				break;
			}
		}
		range = arr[arr.length - 1] - arr[0];
		System.out.println(Math.round(avg));
		System.out.println(center);
		if(flag == 1) System.out.println(many);
		else System.out.println(0-many);
		System.out.println(range);
	}

}
