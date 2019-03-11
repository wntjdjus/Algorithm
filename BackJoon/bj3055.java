import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj3055 {	//bj3055 Å»Ãâ
	/*
	 * .ºó°÷0
	 * *¹°1
	 * Xµ¹2
	 * D±¼3
	 * SÀ§Ä¡7
	 */
	static int r;
	static int c;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {-1,0,1,0};
	static Queue<int[]> q;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		int[][] arr=new int[r][c];
		int[] start=new int[4];
		q=new LinkedList<>();
		for(int i=0;i<r;i++) {
			String str=sc.next();
			for(int j=0;j<c;j++) {
				char c=str.charAt(j);
				if(c=='.') arr[i][j]=0;
				else if(c=='*') {
					arr[i][j]=1;
					int[] temp= {i,j,1,0};
					q.add(temp);
				}
				else if(c=='X') arr[i][j]=2;
				else if(c=='D') arr[i][j]=3;
				else if(c=='S') {
					arr[i][j]=0;
					start[0]=i;
					start[1]=j;
					start[2]=0;
				}
			}
		}
		q.add(start);
		int time=bfs(arr);
		if(time==-1) System.out.println("KAKTUS");
		else System.out.println(time);
	}
	public static int bfs(int[][] arr) {
		boolean[][] chk=new boolean[r][c];
		while(!q.isEmpty()) {
			int[] node=q.remove();
			int y=node[0];
			int x=node[1];
			int status=node[2];
			int time=node[3];
			if(status==3) return time;
			for(int d=0;d<4;d++) {
				int ty=y+dy[d];
				int tx=x+dx[d];
				if(ty<0||ty>=r||tx<0||tx>=c) continue;
				if(arr[ty][tx]==2||arr[ty][tx]==1) continue;
				if(status==1) {
					if(arr[ty][tx]==3) continue;
					arr[ty][tx]=1;
				}
				if(status==0) {
					if(chk[ty][tx])continue;
					chk[ty][tx]=true;
				}
				int[] next= {ty,tx,arr[ty][tx],time+1};
				q.add(next);
			}
		}
		return -1;
	}
}
