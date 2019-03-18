import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw7208 {	// sw7208 Áöµµ Ä¥ÇÏ±â
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int test=Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++) {
			int n=Integer.parseInt(br.readLine().trim());
			int[][] arr=new int[n][n];
			int[] color=new int[n];
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			for(int i=0;i<n;i++) {
				color[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<n;i++) {
				str=br.readLine().trim();
				st=new StringTokenizer(str);
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int[] tcolor=new int[n];
			clone(color,tcolor,n);
			int min=go(arr,tcolor,n,0,0);
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb.toString());
	}
	public static int go(int[][] arr,int[] color,int n,int index,int count) {
		if(index>=n) {
			if(matching(arr,color,n)) return count;
			return Integer.MAX_VALUE;
		}
		int min=Integer.MAX_VALUE;
		for(int i=1;i<=4;i++) {
			int[] tcolor=new int[n];
			clone(color,tcolor,n);
			int temp=0;
			if(i==color[index]) {
				temp=go(arr,tcolor,n,index+1,count);
			}
			else {
				tcolor[index]=i;
				temp=go(arr,tcolor,n,index+1,count+1);
			}
			min=min<temp?min:temp;
		}
		return min;
	}
	public static boolean matching(int[][] arr,int[] color,int n) {
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i][j]==0) continue;
				if(color[i]==color[j]) return false;
			}
		}
		return true;
	}
	public static void clone(int[] arr,int[] tarr,int n) {
		for(int i=0;i<n;i++) {
			tarr[i]=arr[i];
		}
	}
}
