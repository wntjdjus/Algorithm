import java.util.Scanner;

public class bj1562 {	//bj1562 °è´Ü ¼ö
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int maxBit=1<<10;
		int mod=1000000000;
		int[][][] dp=new int[n+1][10][maxBit];
		for(int i=1;i<=9;i++) {
			dp[1][i][1<<i]=1;
		}
		for(int i=2;i<=n;i++) {
			for(int j=0;j<=9;j++) {
				for(int k=0;k<maxBit;k++) {
					if(j-1>=0&&dp[i-1][j-1][k]!=0) dp[i][j][k|1<<j]=(dp[i][j][k|1<<j]+dp[i-1][j-1][k])%mod;
					if(j+1<=9&&dp[i-1][j+1][k]!=0) dp[i][j][k|1<<j]=(dp[i][j][k|1<<j]+dp[i-1][j+1][k])%mod;
				}
			}
		}
		int answer=0;
		for(int i=0;i<=9;i++) {
			answer=(answer+dp[n][i][maxBit-1])%mod;
		}
		System.out.println(answer);
	}
}
