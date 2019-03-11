package com.algorithm.code;

import java.util.Scanner;

public class bj1874 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] stack = new int[100001];
		char[] arr = new char[200002];
		int top = 0;
		int num = 1;
		int index = 0;
		for(int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			while(stack[top] != temp) {
				if(num > temp) {
					System.out.println("NO");
					return;
				}
				stack[++top] = num++;
				arr[index++] = '+';
			}
			arr[index++] = '-';
			top--;
		}
		for(int i = 0; i < index; i++) {
			System.out.println(arr[i]);
		}
	}

}

/*
 * 4 3 6 8 7 5 2 1

1 2 3 4 5 6 7 8

---------------------------------
1
1 2
1 2 3
1 2 3 4
1 2 3          4
1 2             4 3
1 2 5
1 2 5 6
1 2 5          4 3 6
1 2 5 7
1 2 5 7 8
1 2 5 7       4 3 6 8
1 2 5         4 3 6 8 7
1 2           4 3 6 8 7 5
1              4 3 6 8 7 5 2
               4 3 6 8 7 5 2 1


1 2 5 3 4

1
12
123
1234
12345
1234   5

 */
