import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw4613 {	// sw4613 ·¯½Ã¾Æ ±¹±â °°Àº ±ê¹ß
	/*
	 * WÈò1 BÆÄ2 R»¡3
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int test=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++) {
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int[][] arr=new int[n][m];
			int[][] num=new int[n][4];
			for(int i=0;i<n;i++) {
				str=br.readLine().trim();
				for(int j=0;j<m;j++) {
					char c=str.charAt(j);
					if(c=='W') arr[i][j]=1;
					else if(c=='B') arr[i][j]=2;
					else if(c=='R') arr[i][j]=3;
				}
			}
			for(int i=0;i<n;i++) {
				int[] cnt=new int[4];
				for(int j=0;j<m;j++) cnt[arr[i][j]]++;
				for(int j=1;j<=3;j++) num[i][j]=m-cnt[j];
			}
			int min=go(num,0,n,1,0);
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb.toString());
	}
	public static int go(int[][] num,int y,int n,int color, int sum) {
		if(color==3) {
			int count=0;
			for(int i=y;i<n;i++) count+=num[i][color];
			return count+sum;
		}
		int min=Integer.MAX_VALUE;
		for(int i=y+1;i<n;i++) {
			int count=0;
			for(int j=y;j<i;j++) count+=num[j][color]; 
			int temp=go(num,i,n,color+1,sum+count);
			min=min<temp?min:temp;
		}
		return min;
	}
}
