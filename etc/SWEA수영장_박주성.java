import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA수영장_박주성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int test=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++) {
			int[] ticket=new int[4];
			int[] swim=new int[13];
			int[] dp=new int[13];
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			for(int i=0;i<4;i++) {
				ticket[i]=Integer.parseInt(st.nextToken());
			}
			str=br.readLine().trim();
			st=new StringTokenizer(str);
			for(int i=1;i<=12;i++) {
				swim[i]=Integer.parseInt(st.nextToken());
			}
			dp[1]=(ticket[0]*swim[1])<ticket[1]?(ticket[0]*swim[1]):ticket[1];
			dp[2]=(ticket[0]*swim[2])<ticket[1]?(ticket[0]*swim[2]):ticket[1];
			dp[2]+=dp[1];
			for(int i=3;i<=12;i++) {
				dp[i]=dp[i-1]+ticket[0]*swim[i];
				dp[i]=dp[i]<(dp[i-1]+ticket[1])?dp[i]:(dp[i-1]+ticket[1]);
				dp[i]=dp[i]<(dp[i-3]+ticket[2])?dp[i]:(dp[i-3]+ticket[2]);
				dp[i]=dp[i]<(ticket[3])?dp[i]:(ticket[3]);
			}
			sb.append("#"+t+" "+dp[12]+"\n");
		}
		System.out.println(sb.toString());
	}
}
