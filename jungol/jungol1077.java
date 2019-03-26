import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol1077 {	// 정올1077 배낭채우기 1
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine().trim();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int w=Integer.parseInt(st.nextToken());
		int[][] ju=new int[n][2];
		int[] dp=new int[w+1];
		for(int i=0;i<n;i++) {
			str=br.readLine().trim();
			st=new StringTokenizer(str);
			ju[i][0]=Integer.parseInt(st.nextToken());
			ju[i][1]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=w;i++) {
			for(int j=0;j<n;j++) {
				if(i-ju[j][0]<0) continue;
				dp[i]=dp[i]>(dp[i-ju[j][0]]+ju[j][1])?dp[i]:(dp[i-ju[j][0]]+ju[j][1]);
			}
		}
		System.out.println(dp[w]);
	}
}
