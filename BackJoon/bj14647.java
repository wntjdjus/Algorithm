import java.util.Scanner;
import java.util.StringTokenizer;

public class bj14647 {	// bj14647 준오는 조류혐오야!!
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int max=0;
		int guNum=0;
		int[][] arr=new int[n][m];
		int[][] gu=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				String str=sc.next();
				for(int k=0;k<str.length();k++) {
					if(str.charAt(k)-'0'==9) {
						guNum++;
						gu[i][j]++;
					}
				}
			}
		}
//		print(gu,n,m);
		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=0;j<m;j++) {
				count+=gu[i][j];
			}
			max=max>count?max:count;
		}
		for(int j=0;j<m;j++) {
			int count=0;
			for(int i=0;i<n;i++) {
				count+=gu[i][j];
			}
			max=max>count?max:count;
		}
		System.out.println(guNum-max);
	}
	public static void print(int[][] arr,int n,int m) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
