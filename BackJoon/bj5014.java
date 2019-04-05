import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5014_스타트링크_박주성 {	// 백준5014 스타트링크
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine().trim();
		StringTokenizer st=new StringTokenizer(str);
		int f=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());
		int g=Integer.parseInt(st.nextToken());
		int u=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int[] dp=new int[f+1];
		for(int i=0;i<=f;i++) dp[i]=-1;
		int time=0;
		if(u!=0) for(int i=s;i<=f;i+=u) dp[i]=time++;
		time=0;
		if(d!=0) for(int i=s;i>=1;i-=d) dp[i]=time++;
		for(int i=1;i<=f;i++) {
			if(i+d<=f&&dp[i+d]!=-1) {
				if(dp[i]==-1) dp[i]=dp[i+d]+1;
				else dp[i]=dp[i]<dp[i+d]+1?dp[i]:dp[i+d]+1;
			}
			if(i-u>=1&&dp[i-u]!=-1) {
				if(dp[i]==-1) dp[i]=dp[i-u]+1;
				else dp[i]=dp[i]<dp[i-u]+1?dp[i]:dp[i-u]+1;
			}
		}
		if(dp[g]!=-1) System.out.println(dp[g]);
		else System.out.println("use the stairs");
	}
}
