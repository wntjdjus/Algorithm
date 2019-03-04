

import java.util.Scanner;

public class bj15683 {	// bj15683 °¨½Ã
	/*
	 * 0 ºóÄ­
	 * 6 º®
	 * 1~5 CCTV
	 */
	static int n;
	static int m;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {-1,0,1,0};
	static int result=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		int[][] arr=new int[n][m];
		int[][] cctvArr=new int[8][3];
		int cctvNum=0;
		int zero=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]>=1&&arr[i][j]<=5) {
					cctvArr[cctvNum][0]=i;
					cctvArr[cctvNum][1]=j;
					cctvArr[cctvNum][2]=arr[i][j];
					cctvNum++;
				}
				else if(arr[i][j]==0) zero++;
			}
		}
		result=go(arr,cctvArr,cctvNum,zero,0);
		System.out.println(result);
	}
	public static int go(int[][] arr, int[][] cctvArr, int cctvNum, int zero, int index) {
		if(index==cctvNum) {
//			System.out.println("x :"+zero);
//			print(arr);
			return zero;
		}
		int[][] tarr;
		int min=Integer.MAX_VALUE;
		if(cctvArr[index][2]==1) {
			for(int d=0;d<4;d++) {
				tarr=new int[n][m];
				clone(arr,tarr);
				int temp=search(tarr,d,cctvArr[index][0],cctvArr[index][1]);
				int x=go(tarr,cctvArr,cctvNum,zero-temp,index+1);
				min=min<x?min:x;
			}
		}
		else if(cctvArr[index][2]==2) {
			for(int d=0;d<2;d++) {
				tarr=new int[n][m];
				clone(arr,tarr);
				int temp=search(tarr,d,cctvArr[index][0],cctvArr[index][1]);
				int temp2=search(tarr,d+2,cctvArr[index][0],cctvArr[index][1]);
				int x=go(tarr,cctvArr,cctvNum,zero-temp-temp2,index+1);
				min=min<x?min:x;
			}
		}
		else if(cctvArr[index][2]==3) {
			for(int d=0;d<4;d++) {
				tarr=new int[n][m];
				clone(arr,tarr);
				int temp=search(tarr,d,cctvArr[index][0],cctvArr[index][1]);
				int temp2=search(tarr,(d+1)%4,cctvArr[index][0],cctvArr[index][1]);
				int x=go(tarr,cctvArr,cctvNum,zero-temp-temp2,index+1);
				min=min<x?min:x;
			}
		}
		else if(cctvArr[index][2]==4) {
			for(int d=0;d<4;d++) {
				tarr=new int[n][m];
				clone(arr,tarr);
				int temp=search(tarr,d,cctvArr[index][0],cctvArr[index][1]);
				int temp2=search(tarr,(d+1)%4,cctvArr[index][0],cctvArr[index][1]);
				int temp3=search(tarr,(d+2)%4,cctvArr[index][0],cctvArr[index][1]);
				int x=go(tarr,cctvArr,cctvNum,zero-temp-temp2-temp3,index+1);
				min=min<x?min:x;
			}
		}
		else if(cctvArr[index][2]==5) {
			tarr=new int[n][m];
			clone(arr,tarr);
			int temp=search(tarr,0,cctvArr[index][0],cctvArr[index][1]);
			int temp2=search(tarr,1,cctvArr[index][0],cctvArr[index][1]);
			int temp3=search(tarr,2,cctvArr[index][0],cctvArr[index][1]);
			int temp4=search(tarr,3,cctvArr[index][0],cctvArr[index][1]);
			int x=go(tarr,cctvArr,cctvNum,zero-temp-temp2-temp3-temp4,index+1);
			min=min<x?min:x;
//			print(tarr);
		}
		return min;
	}
	public static int search(int[][] arr,int d,int y,int x) {
		int ty=y+dy[d];
		int tx=x+dx[d];
		int count=0;
		while(true) {
			if(ty<0||ty>=n||tx<0||tx>=m) break;
			if(arr[ty][tx]==6) break;
			if(arr[ty][tx]==0) {
				arr[ty][tx]=-1;
				count++;
			}
			ty+=dy[d];
			tx+=dx[d];
		}
		return count;
	}
	public static void clone(int[][] arr, int[][] tarr) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tarr[i][j]=arr[i][j];
			}
		}
	}
//	public static void print(int[][] arr) {
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
