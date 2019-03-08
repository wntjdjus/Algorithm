import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj2636 {	//bj2636 ДЎБо
	static int[] dx= {0,1,0,-1};
	static int[] dy= {-1,0,1,0};
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		int cheese=0;
		int result=0;
		int[][] arr=new int[n][m];
		Queue<int[]> q=new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1) {
					cheese++;
				}
			}
		}
		int time=0;
		int count=cheese;
		while(true) {
			boolean[][] wall=new boolean[n][m];
			int temp=bfs_wall(wall,arr);
			time++;
			cheese=count;
			count-=temp;
			if(count==0) {
				break;
			}
		}
		System.out.println(time+"\n"+cheese);
	}
	public static int bfs_wall(boolean[][] wall,int[][] arr) {
		int count=0;
		Queue<int[]> q=new LinkedList<>();
		int[] start= {0,0};
		wall[0][0]=true;
		q.add(start);
		while(!q.isEmpty()) {
//			System.out.println("A");
			int[] temp=q.remove();
			int y=temp[0];
			int x=temp[1];
			for(int d=0;d<4;d++) {
				int ty=y+dy[d];
				int tx=x+dx[d];
				if(ty<0||ty>=n||tx<0||tx>=m) continue;
				if(wall[ty][tx]) continue;
				if(arr[ty][tx]==1) {
					arr[ty][tx]=0;
					wall[ty][tx]=true;
					count++;
					continue;
				}
				wall[ty][tx]=true;
				int[] next= {ty,tx};
				q.add(next);
			}
		}
		return count;
	}
	public static void zero(int[][] arr,boolean[][] wall) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(wall[i][j]) arr[i][j]=0;
			}
		}
	}
//	public static void print(int[][] arr) {
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
