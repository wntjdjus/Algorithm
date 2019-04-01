import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw3074 {	// sw3074 입국심사
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int test=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++) {
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			int n=Integer.parseInt(st.nextToken());
			long m=Long.parseLong(st.nextToken());
			long[] arr=new long[n];
			for(int i=0;i<n;i++) arr[i]=Long.parseLong(br.readLine().trim());
			long start=0;
			long end=1000000000000000001L;
			while(start<end) {
				long mid=(start+end)>>1;
				long sum=0;
				for(int i=0;i<n;i++) sum+=(mid/arr[i]);
				if(sum>=m) end=mid;
				else start=mid+1;
			}
			
			sb.append("#"+t+" "+end+"\n");
		}
		System.out.println(sb.toString());
	}
}