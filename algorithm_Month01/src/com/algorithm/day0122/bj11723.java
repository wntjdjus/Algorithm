package com.algorithm.day0122;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//������ ����
public class bj11723 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[][] arr = new int[n+1][n+1];	// ���Ῡ��(�����ִ������)
		int[] jus = new int[15];	// ���� ��ġ
		int ju = 0;
		int[][] flag = new int[n+1][50000];	// �湮����(��,�������� ����)
		for(int i = 1; i <= k; i++) {
			int sum = sc.nextInt();
			jus[i] = sum;
			ju = ju | 1<<i;
		}
		for(int i = 0; i < m; i++) {
			int t1 = sc.nextInt();
			int t2 = sc.nextInt();
			int t3 = sc.nextInt();
			arr[t1][t2] = t3;
			arr[t2][t1] = t3;
		}
		//----------------------------------�Է�--------------------------------------
		Queue<int[]> q = new LinkedList<int[]>();
		int max = 0;
		for(int j = 2; j <= n; j++) {	// ó�� 1������ ����� ���� ť�� �ֱ�
			if(arr[1][j] != 0 && flag[j][0] == 0) {
				flag[j][0] = 1;
				int[] tq = {j,0,0};
				q.add(tq);
			}
		}
		while(!q.isEmpty()) {
			int[] tq = q.remove();
			int recent_sum = tq[0];
			int recent_boseok = tq[1];
			int recent_count = tq[2];
			int isboseok = 0;
			int index = -1;
			for(int i = 1; i <= 14; i++) {
				if(jus[i] == recent_sum) {
					isboseok = 1;
					index = i;
					break;
				}
			}
			if(recent_sum == 1) {
				int mycount = recent_count;
				if(isboseok == 1) {
					if((recent_boseok&1<<index) == 0) {
						mycount++;
					}
				}
				max = max>mycount?max:mycount;
			}
			for(int i = 1; i <= n; i++) {
				if(arr[recent_sum][i] != 0) { // ����Ǿ� ���� ��
					// ���� ���� ������ �־ �Ȱ������� ���
					if(recent_count <= arr[recent_sum][i] && flag[i][recent_boseok] == 0) {
						flag[i][recent_boseok] = 1;
						int[] tq2 = {i,recent_boseok,recent_count};
						q.add(tq2);
					}
					// ���� ���� ������ ������ �����ؼ� �������� ���
					if(isboseok == 1) {	// ��������
						int plus_boseok=recent_boseok;
						int plus_count = recent_count;
						if((recent_boseok&1<<index) == 0) {
							plus_boseok = recent_boseok|1<<index;
							plus_count++;
						}
						if(plus_count<=arr[recent_sum][i] && flag[i][plus_boseok] == 0) {
							flag[i][plus_boseok] = 1;
							int[] tq3 = {i,plus_boseok,plus_count};
							q.add(tq3);
						}
					}
				}
			}
		}
		System.out.println(max);
	}

}
























