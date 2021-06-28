import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2449 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int[] arr=new int[n];
		str=br.readLine();
		st=new StringTokenizer(str);
		for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
		int[][] dp=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=i;j>=0;j--) {
				dp[j][i]=Integer.MAX_VALUE;
				if(i==j) {
					dp[j][i]=0;
					continue;
				}
				for(int kk=j;kk<i;kk++) {
					int tmp=(arr[j]==arr[kk+1])?0:1;
					dp[j][i]=Math.min(dp[j][i], dp[j][kk]+dp[kk+1][i]+tmp);
				}
			}
		}
		System.out.println(dp[0][n-1]);
	}
}
