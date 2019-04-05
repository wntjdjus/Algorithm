import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3234_준환이의양팔저울_박주성 {	// swea3234 준환이의 양팔저울
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int test=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++) {
			int n=Integer.parseInt(br.readLine().trim());
			int[] arr=new int[n];
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
			boolean[] chk=new boolean[n];
			int cnt=go(arr,chk,n,0,0,0);
			sb.append("#"+t+" "+cnt+"\n");
		}
		System.out.println(sb.toString());
	}
	public static int go(int[] arr,boolean[] chk,int n,int left,int right,int count) {
		if(count==n) return 1;
		int cnt=0;
		for(int i=0;i<n;i++) {
			if(chk[i]) continue;
			chk[i]=true;
			if(left+arr[i]>=right) cnt+=go(arr,chk,n,left+arr[i],right,count+1);
			if(left>=right+arr[i]) cnt+=go(arr,chk,n,left,right+arr[i],count+1);
			chk[i]=false;
		}
		return cnt;
	}
}
