package com.algorithm.day0122;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1327 {	// ��Ʈ����

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int mask = 0;
		int[] start = new int[n];
		for(int i = 0; i < n; i++) {
			start[i] = sc.nextInt();
			mask += start[i]*(int)Math.pow(10, n-1-i);
		}
		int[][] check = new int[100000000][8];	// �湮���� üũ
		System.out.println(mask);
		Queue<int[]> qarr = new LinkedList<int[]>();
		Queue<Integer> qindex = new LinkedList<Integer>();
		for(int i = 0; n-i >= k; i++) {		// ó�� ���¿��� ������ �Ұ͵� ť���ֱ�
			qarr.add(start);
			qindex.add(i);
		}
		while(!qarr.isEmpty()) {
			
		}
	}

}
