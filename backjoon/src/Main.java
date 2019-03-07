import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {	//bj2636 ДЎБо
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
		boolean[][] wall=new boolean[n][m];
		Queue<int[]> q=new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		bfs_wall(wall,arr);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!wall[i][j]) {
					int[] node= {i,j,1,arr[i][j]};
					q.add(node);
					cheese++;
				}
			}
		}
		int timee=0;
		while(!q.isEmpty()) {
			int[] temp=q.remove();
			int y=temp[0];
			int x=temp[1];
			int time=temp[2];
			if(time>timee) {
				timee=time;
				result=cheese;
			}
			int isCheese=temp[3];
			int flag=0;
			for(int d=0;d<4;d++) {
				int ty=y+dy[d];
				int tx=x+dx[d];
				if(ty<0||ty>=n||tx<0||tx>=m) continue;
				if(wall[ty][tx]) {
					flag=1;
					if(isCheese==1) cheese--;
					wall[y][x]=true;
					break;
				}
			}
			if(flag==0) {
				int[] next= {y,x,time+1};
				q.add(next);
			}
		}
	}
	public static void bfs_wall(boolean[][] wall,int[][] arr) {
		Queue<int[]> q=new LinkedList<>();
		boolean[][] chk=new boolean[n][m];
		int[] start= {0,0};
		wall[0][0]=true;
		q.add(start);
		while(!q.isEmpty()) {
			int[] temp=q.remove();
			int y=temp[0];
			int x=temp[1];
			for(int d=0;d<4;d++) {
				int ty=y+dy[d];
				int tx=x+dx[d];
				if(ty<0||ty>=n||tx<0||tx>=m) continue;
				if(wall[ty][tx]||arr[ty][tx]==1) continue;
				wall[ty][tx]=true;
				int[] next= {ty,tx};
				q.add(next);
			}
		}
	}
}
