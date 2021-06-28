

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj2342 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		
		int[] input=new int[100001];
		int cnt=0;
		while(true) {
			int num=Integer.parseInt(st.nextToken());
			if(num==0) break;
			input[cnt+1]=num;
			cnt+=1;
		}
		if(cnt==0) {
			System.out.println("0");
			return;
		}
		int[][][] dp=new int[cnt+1][5][5];
		for(int i=0;i<cnt+1;i++) {
			for(int j=0;j<5;j++) {
				for(int k=0;k<5;k++) {
					dp[i][j][k]=Integer.MAX_VALUE;
				}
			}
		}
		dp[1][input[1]][0]=2;
		dp[1][0][input[1]]=2;
		
		for(int i=1;i<cnt;i++) {
			int next=input[i+1];
			for(int l=0;l<5;l++) {
				for(int r=0;r<5;r++) {
					if(dp[i][l][r]==Integer.MAX_VALUE) continue;
					if(l==next) dp[i+1][next][r]=Math.min(dp[i+1][next][r], dp[i][l][r]+1);
					else if(l==0 && next!=r) dp[i+1][next][r]=Math.min(dp[i+1][next][r], dp[i][l][r]+2);
					else if((l+next)%2==1 && next!=r) dp[i+1][next][r]=Math.min(dp[i+1][next][r], dp[i][l][r]+3);
					else if((l+next)%2==0 && next!=r) dp[i+1][next][r]=Math.min(dp[i+1][next][r], dp[i][l][r]+4);

					if(r==next) dp[i+1][l][next]=Math.min(dp[i+1][l][next], dp[i][l][r]+1);
					else if(r==0 && next!=l) dp[i+1][l][next]=Math.min(dp[i+1][l][next], dp[i][l][r]+2);
					else if((r+next)%2==1 && next!=l) dp[i+1][l][next]=Math.min(dp[i+1][l][next], dp[i][l][r]+3);
					else if((r+next)%2==0 && next!=l) dp[i+1][l][next]=Math.min(dp[i+1][l][next], dp[i][l][r]+4);
				}
			}
		}
		
		int result=Integer.MAX_VALUE;
		for(int i=0;i<5;i++) result=Math.min(result, dp[cnt][i][input[cnt]]);
		for(int i=0;i<5;i++) result=Math.min(result, dp[cnt][input[cnt]][i]);
		
//		for(int i=0;i<5;i++) {
//			for(int j=0;j<5;j++) {
//				System.out.println(dp[cnt][i][j]);
//			}
//		}
//		
		System.out.println(result);
//		bw.write(result);
//		bw.flush();
		bw.close();
		br.close();
	}

}
