import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol1681 {	// 정올1681 해밀턴 순환회로
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine().trim()); 
		int[][] arr=new int[n][n];
		boolean[] chk=new boolean[n];
		for(int i=0;i<n;i++) {
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			for(int j=0;j<n;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		int min=go(arr,chk,n,0,0,0);
		System.out.println(min);
	}
	public static int go(int[][] arr,boolean[] chk,int n,int index,int sum,int count) {
		if(count==n) return sum;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if(i==index||arr[index][i]==0||chk[i]) continue;
			if(count!=n-1&&i==0) continue;
			chk[i]=true;
			int temp=go(arr,chk,n,i,sum+arr[index][i],count+1);
			chk[i]=false;
			min=min<temp?min:temp;
		}
		return min;
	}
}
