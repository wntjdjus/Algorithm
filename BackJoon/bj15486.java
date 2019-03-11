import java.util.Scanner;

public class B {	//bj15486 Επ»η2
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] work=new int[n+1][2];	// Ti,Pi
		int[] dp=new int[n+2];
		for(int i=1;i<=n;i++) {
			work[i][0]=sc.nextInt();
			work[i][1]=sc.nextInt();
		}
		dp[0]=0;
		for(int i=1;i<=n+1;i++) {
			dp[i]=dp[i]>dp[i-1]?dp[i]:dp[i-1];
			if(i==n+1)break;
			int next=work[i][0]+i;
			if(next<=n+1) {
				dp[next]=dp[next]>work[i][1]+dp[i]?dp[next]:work[i][1]+dp[i];
			}
		}
		System.out.println(dp[n+1]);
	}
}
