import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol2577 {	// 정올2577 회전초밥
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine().trim();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int[] arr=new int[n];
		for(int i=0;i<n;i++) arr[i]=Integer.parseInt(br.readLine().trim());
		int[] chk=new int[d+1];
		int max=0;
		int count=0;
		for(int i=0;i<n;i++) {
			if(i==0) {
				for(int j=0;j<k;j++) chk[arr[j]]+=1;
				for(int j=1;j<=d;j++) if(chk[j]!=0) count++;
			}
			else {
				chk[arr[i-1]]-=1;
				if(chk[arr[i-1]]==0) count--;
				if(chk[arr[(i+k-1)%n]]==0) count++;
				chk[arr[(i+k-1)%n]]+=1;
				
			}
			if(chk[c]==0) max=max>count+1?max:count+1;
			else max=max>count?max:count;
		}
		System.out.println(max);
	}
}
