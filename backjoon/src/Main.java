import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {	// bj16236 아기 상어
	/*
	 * 0 빈칸
	 * 1~6 물고기 크기
	 * 9 상어위치
	 */
	static int n;
	static int[] dx= {0,-1,1,0};
	static int[] dy= {-1,0,0,1};
	static int level=2;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int[][] arr=new int[n][n];
		int startY=0;
		int startX=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==9) {
					startY=i;
					startX=j;
				}
			}
		}
		int time=go(arr,startY,startX);
		System.out.println(time);
	}
	public static int go(int[][] arr,int startY,int startX) {
		int y=startY;
		int x=startX;
		int time=0;
		int eat=0;
		while(true) {
			int[] temp=bfs(arr,y,x);
			if(temp[2]==-1) return time;
			arr[y][x]=0;
			arr[temp[0]][temp[1]]=9;
			time+=temp[2];
			eat++;
			if(level==eat) {
				level++;
				eat=0;
			}
			y=temp[0];
			x=temp[1];
		}
	}
	public static int[] bfs(int[][] arr,int a,int b) {
		Queue<int[]> q=new LinkedList<int[]>();
		boolean[][] chk=new boolean[n][n];
		int[] start= {a,b,0};
		q.add(start);
		chk[a][b]=true;
		while(!q.isEmpty()) {
			int[] temp=q.remove();
			int y=temp[0];
			int x=temp[1];
			for(int d=0;d<4;d++) {
				int ty=y+dy[d];
				int tx=x+dx[d];
				if(ty<0||ty>=n||tx<0||tx>=n) continue;
				if(chk[ty][tx]) continue;
				if(arr[ty][tx]>level) continue;
				else if(arr[ty][tx]<level&&arr[ty][tx]>0) {
					int[] k= {ty,tx,temp[2]+1};
					return k;
				}
				chk[ty][x]=true;
				int[] next= {ty,tx,temp[2]+1};
				q.add(next);
			}
		}
		int[] error= {-1,-1,-1};
		return error;
	}
}
