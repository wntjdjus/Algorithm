import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1102 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int[][] dp=new int[n+1][1<<(n+1)];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<(1<<(n+1));j++) dp[i][j]=Integer.MAX_VALUE;
		}
		int[][] arr=new int[n+1][n+1];
		String str;
		StringTokenizer st;
		for(int i=1;i<=n;i++) {
			str=br.readLine();
			st=new StringTokenizer(str);
			for(int j=1;j<=n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		str=br.readLine();
		int length=str.length();
		int start=0;
		int cnt=0;
		dp[0][0]=0;
		for(int i=0;i<length;i++) {
			if(str.charAt(i)=='Y') {
				start=start|(1<<(i+1));
				cnt+=1;
				dp[cnt][start]=0;
			}
		}
		int p=Integer.parseInt(br.readLine());
		
		for(int i=cnt;i<p;i++) {
			for(int j=0;j<(1<<(n+1));j++) {
				if(dp[i][j]==Integer.MAX_VALUE) continue;
				for(int u=1;u<=n;u++) {
					if((j&(1<<u))==0) continue;
					for(int v=1;v<=n;v++) {
						if((j&(1<<v))!=0) continue;
						dp[i+1][j|1<<v]=Math.min(dp[i+1][j|1<<v], dp[i][j]+arr[u][v]);
					}
				}
			}
		}
		
		int result=Integer.MAX_VALUE;
		for(int i=0;i<(1<<(n+1));i++) {
			result=Math.min(result, dp[p][i]);
		}
		if(result==Integer.MAX_VALUE) result=-1;
		System.out.println(result);
	}
}
