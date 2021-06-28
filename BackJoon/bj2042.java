import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj2042 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int size=1;
		while(size<n) {
			size=size<<1;
		}
		long[] arr=new long[size*2];
		for(int i=size;i<size+n;i++) arr[i]=Long.parseLong(br.readLine());
		for(int i=size>>1;i>=1;i=i>>1) {
			for(int j=i;j<i*2;j++) {
				arr[j]=arr[j*2]+arr[j*2+1];
			}
		}
		for(int i=0;i<m+k;i++) {
			str=br.readLine();
			st=new StringTokenizer(str);
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if(a==1) change(arr,size+b-1,c);
			else bw.write(go(arr,size+b-1,size+c-1)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void change(long[] arr, int index, int num) {
		arr[index]=num;
		while(index>1) {
			index=index>>1;
			arr[index]=arr[index*2]+arr[index*2+1];
		}
	}
	public static long go(long[] arr, int l, int r) {
		long sum=0;
		while(l<r) {
			if(l%2==1) {
				sum+=arr[l];
				l+=1;
			}
			if(r%2==0) {
				sum+=arr[r];
				r-=1;
			}
			l=l>>1;
			r=r>>1;
		}
		if(l==r) sum+=arr[l];
		return sum;
	}
}
