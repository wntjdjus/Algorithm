package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2750 {	// 수 정렬하기

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		quickSort(arr,0,n-1);
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
	}
	public static void quickSort(int[] arr, int start, int end) {
		if(start>=end) return;
		int pivot = selectPivot(arr,start,end);
		quickSort(arr,start,pivot-1);
		quickSort(arr,pivot+1,end);
	}
	public static int selectPivot(int[] arr, int start, int end) {
		int pivot = start;
		int left = pivot+1;
		int right = end;
		
		do {
			while(left!=end&&arr[left]<=arr[pivot]) left++;
			while(right!=pivot&&arr[right]>=arr[pivot]) right--;
			if(left<right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}while(left<right);
		int temp = arr[right];
		arr[right] = arr[pivot];
		arr[pivot] = temp;
		
		return right;
	}

}
