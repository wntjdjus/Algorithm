import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {	// bj16137 °ß¿ì¿Í Á÷³à
	static int[] dx= {0,1,0,-1};
	static int[] dy= {-1,0,1,0};
	static int n;
	static int ttime=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int m=sc.nextInt();
		int[][] arr=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		Queue<int[]> q=new LinkedList<>();
		boolean[][][] chk=new boolean[n][n][2];
		int[] start= {0,0,0,1};
		q.add(start);
		while(!q.isEmpty()) {
			int[] node=q.remove();
			int y=node[0];
			int x=node[1];
			int time=node[2];
			int flag=node[3];
			if(y==n-1&&x==n-1) {
				ttime=ttime<time?ttime:time;
			}
			for(int d=0;d<4;d++) {
				int ty=y+dy[d];
				int tx=x+dx[d];
				if(ty<0||ty>=n||tx<0||tx>=n) continue;
				if(chk[ty][tx][flag]) continue;
				if(arr[ty][tx]==1) {
					chk[ty][tx][flag]=true;
					int[] temp= {ty,tx,time+1,flag};
					q.add(temp);
				}
				else if(arr[ty][tx]==0&&flag==1) {
					if(time==0||(time+1)%m==0) {
						chk[ty][tx][0]=true;
						chk[ty][tx][1]=true;
						int[] temp= {ty,tx,time+1,0};
						q.add(temp);
					}
					else {
						int[] temp= {ty,tx,arr[ty][tx],0};
						q.add(temp);
					}
				}
				else if(arr[ty][tx]!=0) {
					if(time==0||(time+1)%arr[ty][tx]==0) {
						chk[ty][tx][0]=true;
						chk[ty][tx][1]=true;
						int[] temp= {ty,tx,time+1,0};
						q.add(temp);
					}
					else {
						int[] temp= {ty,tx,m,0};
						q.add(temp);
					}
				}
			}
		}
		System.out.println(ttime);
	}
}
