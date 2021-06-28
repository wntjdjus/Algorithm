import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj16637 {
	// 백준 16637 : 괄호 추가하기
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=null;
		
		int n=Integer.parseInt(br.readLine());
		String str=br.readLine();
		long[] arr=new long[n];
		boolean[] flag=new boolean[n]; // 홀수만 사용
		for(int i=0;i<n;i++) {
			int tmp=str.charAt(i) - '0';
			arr[i]=tmp;
		}
		long result=go(arr,flag,1,n);
		bw.append(result+"");
		
		bw.flush();
		br.close();
		bw.close();
	}
	public static long go(long[] arr, boolean[] chk, int seq, int max) {
		if(seq==max) {
			return bfCal(arr, chk);
		}
		long result=Long.MIN_VALUE;
		long t1=go(arr,chk,seq+2,max);
		if(t1>result) result=t1;
		if(seq==1 || !chk[seq-2]) {
			chk[seq]=true;
			t1=go(arr,chk,seq+2,max);
			if(t1>result) result=t1;
			chk[seq]=false;
		}
		return result;
	}
	public static long cal(long[] arr,int start, int end) {
		long result=arr[start];
		for(int i=start+2;i<=end;i+=2) {
			char op=(char)(arr[i-1]+'0');
			if(op=='+') {
				result+=arr[i];
			}else if(op=='-') {
				result-=arr[i];
			}else if(op=='*') {
				result*=arr[i];
			}else {
				return -9999;
			}
		}
		return result;
	}
	public static long bfCal(long[] arr, boolean[] flag) {
		int l=arr.length;
		long[] tarr=new long[l];
		for(int i=0;i<l;i++) {
			tarr[i]=arr[i];
		}
		for(int i=0;i<l-2;i+=2) {
			if(flag[i+1]) {
				long tmp=cal(tarr,i,i+2);
				tarr[i]=tmp;
				tarr[i+1]='+'-'0';
				tarr[i+2]=0;
			}
		}
		long result=cal(tarr,0,l-1);
		return result;
	}
}
