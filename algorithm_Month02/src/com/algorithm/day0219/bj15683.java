package com.algorithm.day0219;

import java.util.Scanner;

public class bj15683 {
	public static class CCTV{
		int x;
		int y;
		int code;
		public CCTV() {
			
		}
		public CCTV(int y,int x,int code) {
			this.y=y;
			this.x=x;
			this.code=code;
		}
	}
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static int n;
	static int m;
	static int[][] arr;
	static CCTV[] cctvArr;
	static int index;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		arr=new int[n][m];
		cctvArr=new CCTV[10];
		index=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]>0&&arr[i][j]<6) {
					cctvArr[index++]=new CCTV(i,j,arr[i][j]);
				}
			}
		}
		
	}
}
