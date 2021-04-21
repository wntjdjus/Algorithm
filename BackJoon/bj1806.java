import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1806 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());
		int[] arr=new int[n];
		str=br.readLine();
		st=new StringTokenizer(str);
		for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
		int l=0;
		int r=0;
		int sum=0;
		int length=Integer.MAX_VALUE;
		while(true) {
			if(sum>=s) {
				sum-=arr[l];
				l+=1;
			}else if(r==n) {
				break;
			}else {
				sum+=arr[r];
				r+=1;
			}
			if(sum>=s) length=Math.min(length, r-l);
		}
//		if(sum>=s) length=Math.min(length, r-l);
		if(length==Integer.MAX_VALUE) System.out.println("0");
		else System.out.println(length);
	}
}
