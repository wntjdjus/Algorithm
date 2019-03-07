import java.util.Scanner;

public class sw1861 {	//sw1861 정사각형 방
	static int n;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {-1,0,1,0};
	static int[] room;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int t=1;t<=test;t++) {
			n=sc.nextInt();
			room=new int[n*n+1];
			int[][] arr=new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			go(arr,0);
			int num=0;
			int max=0;
			for(int i=0;i<n*n+1;i++) {
				if(room[i]>max) {
					num=i;
					max=room[i];
				}
			}
			System.out.println("#"+t+" "+num+" "+max);
		}
	}
	public static void go(int[][] arr,int num) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(room[arr[i][j]]==0) {
					room[arr[i][j]]=dfs(arr,i,j,arr[i][j]);
				}
			}
		}
	}
	public static int dfs(int[][] arr,int y,int x,int num) {
		if(num==n*n) {
			room[arr[y][x]]=1;
			return 1;
		}
		int result=1;
		for(int d=0;d<4;d++) {
			int ty=y+dy[d];
			int tx=x+dx[d];
			if(ty<0||ty>=n||tx<0||tx>=n) continue;
			if(arr[ty][tx]==arr[y][x]+1) {
				result=dfs(arr,ty,tx,num+1)+1;
				break;
			}
		}
		room[arr[y][x]]=result;
		return result;
	}
}
