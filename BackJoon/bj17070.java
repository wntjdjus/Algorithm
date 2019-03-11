import java.util.Scanner;

public class bj17070 {	//bj17070 파이프 옮기기 1
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] arr=new int[n+1][n+1];
		int[][][] dp=new int[n+1][n+1][3];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		dp[1][2][0]=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(arr[i][j]==1) continue;
				dp[i][j][0]+=dp[i][j-1][0]+dp[i][j-1][1];
				if(arr[i][j-1]!=1&&arr[i-1][j]!=1) {
					dp[i][j][1]+=dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
				}
				dp[i][j][2]+=dp[i-1][j][1]+dp[i-1][j][2];
			}
		}
		System.out.println(dp[n][n][0]+dp[n][n][1]+dp[n][n][2]);
	}
}
