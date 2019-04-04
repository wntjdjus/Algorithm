import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5672_올해의조련사_박주성 {	// sw5672 올해의 조련사
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int test=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++) {
			int n=Integer.parseInt(br.readLine().trim());
			char[] arr=new char[n];
			char[] result=new char[n];
			int index=0;
			for(int i=0;i<n;i++) arr[i]=br.readLine().trim().charAt(0);
			int left=0;
			int right=n-1;
			while(left<=right) {
				if(compare(arr,left,right)<0) result[index++]=arr[left++];
				else result[index++]=arr[right--];
			}
			sb.append("#"+t+" ");
			for(int i=0;i<index;i++) sb.append(result[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static int compare(char[] arr,int left,int right) {
		if(right<=left) return 0;
		if(arr[left]==arr[right]) return compare(arr,left+1,right-1);
		return arr[left]-arr[right];
	}
}
