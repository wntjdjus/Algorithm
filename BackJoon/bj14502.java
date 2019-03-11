import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A {	// bj14502 ¿¬±¸¼Ò
	static int n;
	static int m;
	static int[][] basic;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static int zeroCount=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		basic=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				basic[i][j]=sc.nextInt();
				if(basic[i][j]==0) zeroCount++;
			}
		}
		int max=go(basic,0);
		System.out.println(max);
	}
	public static int go(int[][] arr,int count) {
		if(count==3) {
			int zero=zeroCount-3;
			return virus(arr,zero);
		}
		int max=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]!=0) continue;
				arr[i][j]=1;
				int temp=go(arr,count+1);
				max=max>temp?max:temp;
				arr[i][j]=0;
			}
		}
		return max;
	}
	public static int virus(int[][] arr, int zero) {
		int[][] tarr=new int[n][m];
		boolean[][] visit=new boolean[n][m];
		clone(arr,tarr);
		Queue<int[]> q=new LinkedList<int[]>();
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(tarr[i][j]==2&&!visit[i][j]) {
					int[] point=new int[2];
					point[0]=i;
					point[1]=j;
					q.add(point);
					visit[i][j]=true;
				}
			}
		}
		while(!q.isEmpty()) {
			int[] p=q.remove();
			int y=p[0];
			int x=p[1];
			for(int d=0;d<4;d++) {
				int ty=y+dy[d];
				int tx=x+dx[d];
				if(tx<0||tx>=m||ty<0||ty>=n) continue;
				if(tarr[ty][tx]!=0||visit[ty][tx]) continue;
				visit[ty][tx]=true;
				tarr[ty][tx]=2;
				zero--;
				int[] next=new int[2];
				next[0]=ty;
				next[1]=tx;
				q.add(next);
			}
		}
		return zero;
	}
	public static void clone(int[][] arr, int[][] tarr) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tarr[i][j]=arr[i][j];
			}
		}
	}
}
