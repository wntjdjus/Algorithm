import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17136 {	// 백준17136 색종이 붙이기 
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[][] arr=new int[10][10];
		int cnt=0;
		for(int i=0;i<10;i++) {
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			for(int j=0;j<10;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) cnt+=1;
			}
		}
		if(cnt==0) {
			System.out.println(cnt);
			return;
		}
		int[] block= {5,5,5,5,5};	// 5,4,3,2,1 크기
		int min=go(arr,block,cnt);
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	public static int go(int[][] arr,int[] block,int cnt) {
		if(cnt==0) return 0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(arr[i][j]==0) continue;
				for(int d=0;d<5;d++) {
					if(block[d]==0) continue;
					if(i+(5-d)>10||j+(5-d)>10) continue;
					if(!check(arr,i,j,(5-d))) continue;
					block[d]-=1;
					clear(arr,i,j,(5-d));
					int dCnt=(5-d)*(5-d);
					int temp=go(arr,block,cnt-dCnt);
					if(temp!=Integer.MAX_VALUE) temp+=1;
					min=min<temp?min:temp;
					full(arr,i,j,(5-d));
					block[d]+=1;
				}
				return min;
			}
		}
		return min;
	}
	public static boolean check(int[][] arr,int y,int x,int d) {
		for(int i=y;i<y+d;i++) {
			for(int j=x;j<x+d;j++) {
				if(arr[i][j]==0) return false;
			}
		}
		return true;
	}
	public static void clear(int[][] arr,int y,int x,int d) {
		for(int i=y;i<y+d;i++) {
			for(int j=x;j<x+d;j++) {
				arr[i][j]=0;
			}
		}
	}
	public static void full(int[][] arr,int y,int x,int d) {
		for(int i=y;i<y+d;i++) {
			for(int j=x;j<x+d;j++) {
				arr[i][j]=1;
			}
		}
	}
}
