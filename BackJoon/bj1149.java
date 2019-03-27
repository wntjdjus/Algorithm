import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {	// bj1149 RGB°Å¸®
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine().trim());
		int[][] dp=new int[n+1][3];
		for(int i=1;i<=n;i++) {
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			for(int j=0;j<3;j++) {
				int t=Integer.parseInt(st.nextToken());
				dp[i][j]=Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3])+t;
			}
		}
		System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
	}
}
