import java.util.Scanner;

public class bj10164 {	//bj10164	격자상의 경로
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		int[][] arr=new int[n][m];
		int num=0;
		int indexI=n;
		int indexJ=m;
		arr[0][0]=1;
		if(k!=0) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					num++;
					if(num==k) {
						indexI=i;
						indexJ=j;
					}
				}
			}
			for(int i=0;i<=indexI;i++) {
				for(int j=0;j<=indexJ;j++) {
					if(i+1<=indexI) arr[i+1][j]+=arr[i][j];
					if(j+1<=indexJ) arr[i][j+1]+=arr[i][j];
				}
			}
			for(int i=indexI;i<n;i++) {
				for(int j=indexJ;j<m;j++) {
					if(i+1<n) arr[i+1][j]+=arr[i][j];
					if(j+1<m) arr[i][j+1]+=arr[i][j];
				}
			}
			System.out.println(arr[n-1][m-1]);
		}
		else {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(i+1<n) arr[i+1][j]+=arr[i][j];
					if(j+1<m) arr[i][j+1]+=arr[i][j];
				}
			}
			System.out.println(arr[n-1][m-1]);
		}
	}
}
