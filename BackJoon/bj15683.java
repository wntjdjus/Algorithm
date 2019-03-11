package com.algorithm.day0219;

import java.util.Scanner;

public class bj15683 {	// 감시
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
	static final int up=0;
	static final int down=1;
	static final int left=2;
	static final int right=3;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		arr=new int[n][m];
		cctvArr=new CCTV[10];
		index=0;
		int no=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]>0&&arr[i][j]<6) {
					cctvArr[index++]=new CCTV(i,j,arr[i][j]);
				}
				else if(arr[i][j]==0) no++;
			}
		}
		System.out.println("처음 사각지대 : "+no);
		int min=dfs(0,arr,no);
		System.out.println(min);
	}
	public static void clone(int[][] aarr,int[][] barr) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				barr[i][j]=aarr[i][j];
			}
		}
	}
	public static int dfs(int in,int[][] tarr,int no) {
		if(in==index) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					System.out.print(tarr[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			return no;
		}
		int[][] newArr;
		int min=no;
		int tno;
		int num;
		switch(cctvArr[in].code) {
		case 1:
			for(int i=0;i<4;i++) {
				newArr=new int[n][m];
				clone(tarr,newArr);
				tno=go(newArr,i,no,cctvArr[in]);
				num=dfs(in+1,newArr,tno);
				min=min<num?min:num;
			}
			break;
		case 2:
			for(int i=0;i<2;i++) {
				newArr=new int[n][m];
				clone(tarr,newArr);
				tno=go(newArr,i,no,cctvArr[in]);
				tno=go(newArr,i+1,tno,cctvArr[in]);
				num=dfs(in+1,newArr,tno);
				min=min<num?min:num;
			}
			break;
		case 3:
			for(int i=0;i<3;i++) {
				newArr=new int[n][m];
				clone(tarr,newArr);
				tno=go(newArr,i,no,cctvArr[in]);
				tno=go(newArr,i+1,tno,cctvArr[in]);
				num=dfs(in+1,newArr,tno);
				min=min<num?min:num;
			}
			break;
		case 4:	// 012 123 230 301
			for(int i=0;i<4;i++) {	// i=3 : 3 4 5 -> 3 0 1
				newArr=new int[n][m];
				clone(tarr,newArr);
				tno=go(newArr,i%4,no,cctvArr[in]);
				tno=go(newArr,(i+1)%4,tno,cctvArr[in]);
				tno=go(newArr,(i+2)%4,tno,cctvArr[in]);
				num=dfs(in+1,newArr,tno);
				min=min<num?min:num;
			}
			break;
		case 5:
			newArr=new int[n][m];
			clone(tarr,newArr);
			tno=go(newArr,0,no,cctvArr[in]);
			tno=go(newArr,1,tno,cctvArr[in]);
			tno=go(newArr,2,tno,cctvArr[in]);
			tno=go(newArr,3,tno,cctvArr[in]);
			num=dfs(in+1,newArr,tno);
			min=min<num?min:num;
			break;
		}
		return min;
	}
	public static int go(int[][] tarr,int d,int no,CCTV cctv) {
		int x=cctv.x+dx[d];
		int y=cctv.y+dy[d];
		while(true) {
			if(x<0||x>=m||y<0||y>=n) break;
			if(tarr[y][x]==6)break;
			if(tarr[y][x]==0) {
				tarr[y][x]=-1;
				no--;
			}
			//System.out.println(no);
			x+=dx[d];
			y+=dy[d];
		}
		return no;
	}
}
