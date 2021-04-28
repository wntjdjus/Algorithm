import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14003 {

public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int[] arr=new int[n];
		for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
		int[] save=new int[n];
		int[] lis=new int[n];
		lis[0]=arr[0];
		save[0]=0;
		int idx=0;
		for(int i=1;i<n;i++) {
			if(arr[i]>lis[idx]) {
				idx+=1;
				lis[idx]=arr[i];
				save[i]=idx;
			}else {
				int tidx=go(lis,0,idx,arr[i]);
				lis[tidx]=arr[i];
				save[i]=tidx;
			}
		}
		System.out.println(idx+1);
		int tmp=idx;
		int top=-1;
		int[] stack=new int[n];
		for(int i=n-1;i>=0;i--) {
			if(save[i]==tmp) {
				stack[++top]=arr[i];
				tmp-=1;
			}
		}
		for(int i=top;i>=0;i--) {
			System.out.print(stack[i]+" ");
		}
	}
	public static int go(int[] lis, int start, int end, int g) {
		int l=start;
		int r=end;
		while(l<r) {
//			System.out.println("AA");
			int mid=(l+r)>>1;
			if(lis[mid]<g) l=mid+1;
			else r=mid;
		}
		return l;
	}
}
